var express = require('express');
var router = express.Router();


router.route("/").get(function(req,res){
    res.status(200).send("this is our home page")
});
module.exports = router;