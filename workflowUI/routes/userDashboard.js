exports.loginPage = function (req, res) {
    //req.session.email = req.param('email');
    //console.log("session email :: " + req.session.email);
    res.render("userDashboard"/*,{"email" : req.session.email}*/);
}

