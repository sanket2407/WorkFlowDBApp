
exports.loginPage = function (req, res) {
    console.log("in loginpage server which will render orgAdminDshBoard");
    console.log("email param :: " + req.param("email_id"));
    email = req.param('email_id');
    console.log("email :: " + email);
    res.render("deptAdminDashBoard"/*,{"email" : req.session.email}*/);
}
