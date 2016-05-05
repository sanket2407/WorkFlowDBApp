exports.loginPage = function (req, res) {
    console.log("in loginpage server which will render orgAdminDshBoard");
    console.log("email :: " + req.param("email_id"));
    console.log("Organization :: " + req.param("org_name"));
    email = req.param('email_id');
    org_name = req.param('org_name');
    console.log("email :: " + email);
    res.render("userDashboard",{"email" : email, "org_name": org_name});
}

