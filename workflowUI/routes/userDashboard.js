exports.loginPage = function (req, res) {
    console.log("in loginpage server which will render orgAdminDshBoard");
    console.log("email :: " + req.param("email_id"));
    console.log("Organization :: " + req.param("org_name"));
    console.log("department :: " + req.param("dept_id"));
    console.log("organization :: " + req.param("dept_id"));

    email = req.param('email_id');
    org_name = req.param('org_name');
    dept_id=req.param('dept_id');
    org_id=req.param('org_id');
    res.render("userDashboard",{"email" : email, "org_name": org_name, "dept_id":dept_id, "org_id":org_id});
}

