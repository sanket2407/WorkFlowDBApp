
exports.loginPage = function (req, res) {
    console.log("in loginpage server which will render orgAdminDshBoard");
    console.log("email param :: " + req.param("email_id"));
    email = req.param('email_id');
    org_name=req.param('org_name');
    console.log("email :: " + email);
    console.log("org name :: " + org_name);
    res.render("deptAdminDashBoard",{"email" : email, "org_name": org_name});
}
