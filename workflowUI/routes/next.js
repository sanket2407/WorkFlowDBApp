exports.nextLevel = function (req, res) {

    console.log("workflow_id:: " + req.param("workflow_id"));

    workflow_id = req.param("workflow_id");
    org_name = req.param("org_name");
    level_name = req.param("level_name");
    layer_name = req.param("layer_name");
    res.render("next",{"workflow_id" : workflow_id, "org_name" : org_name, "level_name" : level_name, "layer_name":layer_name});

}
