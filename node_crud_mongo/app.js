'use strict';

const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const User = require("./models/user");

const mongoose = require('mongoose');
 
mongoose.connect('mongodb://localhost/demo', {useNewUrlParser: true});

app.use(bodyParser.json({ limit: 100000 }));
app.use(bodyParser.urlencoded({
	extended: true
}));




// Create
 app.post('/createUser', function (req, res) {
   console.log("Got a POST request for the homepage");
   let query = {
      first_name: req.body.first_name,
      last_name: req.body.last_name
   };
	
	let UserData = new User({
      first_name: "Muzamil1",
      last_name: "Ahmed1",
      age: "261",
      username: "mak1",
      password: "1231321",
      
  })

   UserData.save()
   .then((data)=>{
   	res.json(data);
   })
   .catch((err)=>{
   	res.send("error "+ err);
   })
})

// Read
app.get('/user/:id', function (req, res) {
   
   User.find({ "username" : "mak1New"})
   .then((data)=>{
   	res.json(data);
   })
   .catch((err)=>{
   	res.send("error "+ err);
   })
 
})

// Delete
app.delete('/deleteUser/:id', function (req, res) {
   var ObjectId = require('mongodb').ObjectId;
   User.deleteOne({username:"mak1"})
   .exec(function(err,data){
      res.send("Deleted Successfully !");
   })
  
})
// Update 
app.put('/updateUser/:id', function (req, res) {
   var ObjectId = require('mongodb').ObjectId;
   User.updateOne(
      { username: "mak1"}, // Filter
      {$set: {
         first_name: "Muzamil1New",
         last_name: "Ahmed1New",
         age: "261",
         username: "mak1New",
         password: "1231321New",
         
     }}, // Update
      {upsert: true} // add document with req.body._id if not exists 

 )
.then((obj) => {
   console.log('Updated - ' + obj);
   res.send("Record updated");
})
   .catch((err) => {
   console.log('Error: ' + err);
   })
  
})

const server = app.listen(8081, function () {
   const host = server.address().address
   const port = server.address().port
   
   console.log("Example app listening at http://%s:%s", host, port)
});