
exports.loginPage = function (req, res) {
    console.log("in loginpage server which will render orgAdminDshBoard");
    console.log("email param :: " + req.param("admin_email"));
    console.log("email param :: " + req.param("org_name"));
    email = req.param('admin_email');
    org_name = req.param('org_name');
    console.log("email :: " + email);
    res.render("orgAdminDashBoard",{"email" : email, "org_name": org_name});
}
