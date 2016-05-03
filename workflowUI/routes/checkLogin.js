var mysql = require('./mysql');

exports.checklogin = function(req,res) {

    console.log("in checklogin");
    var email = req.param("email");
    var password = req.param("password");
    console.log("email :: " + email);
    console.log("password :: " + password);
    if(email != '') {
        var checkLoginQuery = "select email_id from user where email_id = '" + email + "' and password = '" + password + "'";
        console.log("Query:: " + checkLoginQuery);

        mysql.fetchData(function(err,results) {
            if(err) {
                throw err;
            }
            else {
                if(results.length > 0) {
                    //if(bcrypt.compareSync(password,results[0].password)) {
                    console.log("Successful Login");
                    console.log("Username :  " + results[0].username);
                    
                    //Assigning the session
                    /*  
                     req.session.email = email;
                     req.session.username = results[0].username;
                     req.session.userid = results[0].userid;
                     console.log("Session Initialized with email : " + req.session.email);
                     console.log("username :: " + req.session.username);
                     console.log("userid :: " + req.session.userid);*/
                    json_responses = {"statusCode" : 200};
                    res.send(json_responses);
                }
                //else {
                //	console.log("Invalid Password");
                //	json_responses = {"statusCode" : 401};
                //	res.send(json_responses);
                //}
                //}
                else {
                    console.log("Invalid Login");
                    json_responses = {"statusCode" : 401};
                    res.send(json_responses);
                }
            }
        }, checkLoginQuery);
    }
}
