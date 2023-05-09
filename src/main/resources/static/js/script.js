var app = new Vue({
    el: '#app',
    data: {
        rows: [],
        hiddenrows: [],
        newItem: "",
        editForm: {
//            id: '',
//            content: '',
//            completed: false
        },
        button: {
            text: "Hide"
        },
        seen: true,
        pageSize: 5,
        currentPage: 1,
    },
    created: async function () {
        await fetch('http://localhost/spring/api/todos').then(response => {
            return response.json();
        }).then(rows => this.rows = rows);
        this.rows.sort((a, b) => a.completed - b.completed || a.id - b.id);
    },
    methods: {
        saveTodo: function (row) {
            if (Object.keys(this.editForm).length === 0) {
                this.editForm = row;
            }
            fetch("http://localhost/spring/api/todos/" + this.editForm.id, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(this.editForm) // body data type must match "Content-Type" header
            });
            this.editForm = {};
            this.rows.sort((a, b) => a.completed - b.completed || a.id - b.id);
        },

        deleteTodo: function (row) {
            fetch("http://localhost/spring/api/todos/" + row.id, {
                method: "DELETE",
                headers: {
                    "Content-Type": "application/json"
                }
            });
            this.rows.splice(this.rows.findIndex(el => el.id === row.id), 1);
        },

        editTodo: function (row) {
            this.editForm = row;
        },

        addTodo: async function () {
            await fetch("http://localhost/spring/api/todos", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({id: 0, content: this.newItem, completed: false})
            });
            fetch('http://localhost/spring/api/todos').then(response => {
                return response.json();
            }).then(rows => this.rows = rows);
            this.rows.sort((a, b) => a.completed - b.completed || a.id - b.id);
        },

        hideList: function () {
            this.seen = !app.seen;
            this.button.text = app.seen ? 'Hide' : 'Show';
            if (this.hiddenrows.length <= 0) {
                this.hiddenrows = this.rows.filter(item => item.completed === true);
                this.rows = this.rows.filter(item => item.completed === false);
            } else if (this.hiddenrows.length > 0) {
                this.rows = this.rows.concat(this.hiddenrows);
                this.hiddenrows = [];
            }
            this.rows.sort((a, b) => a.completed - b.completed || a.id - b.id);
        },
        
        nextPage: function () {
            if ((this.currentPage * this.pageSize) < this.rows.length)
                this.currentPage++;
        },
        prevPage: function () {
            if (this.currentPage > 1)
                this.currentPage--;
        },
    },
    computed: {
        sortedrows: function () {
            return this.rows.filter((row, index) => {
                let start = (this.currentPage - 1) * this.pageSize;
                let end = this.currentPage * this.pageSize;
                if (index >= start && index < end)
                    return true;
            });
        }
    }
});