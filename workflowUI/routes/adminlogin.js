exports.loginPage = function (req, res) {
    res.render("adminlogin",req.session.email);
}
