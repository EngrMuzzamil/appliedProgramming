var fs = require("fs");
module.exports = {
    // Covert JavaScript object into JSON string
    create: function(title,body) {
        const book = {
            title: title,
            author: body
            }
            fs.writeFile("note.txt", JSON.stringify(book), (err) => {
            if (err) console.log(err);
            console.log("Successfully Written to File.");
            });
    },
    read: function() {
        fs.readFile("note.txt", function(err, buf) {
            if (err) { console.log(err) }
            console.log(JSON.parse(buf));
          });
    },
    update: function(title,body) {
        const bookupdate = {
            title: title,
            author: body
            }
            fs.writeFile("note.txt", JSON.stringify(bookupdate), (err) => {
            if (err) console.log(err);
            console.log("Successfully Updated File.");
            });
    },
    delete: function() {
        fs.writeFile("note.txt", "", (err) => {
            if (err) console.log(err);
            console.log("Text removed successfully.");
            });
    },
};