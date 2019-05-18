const express = require('express');
const app = express();

app.get("/hi",(req,res)=>{
    res.send("Hello World 123123123123");
});

app.listen(8080,()=>
    console.log("server running")
)