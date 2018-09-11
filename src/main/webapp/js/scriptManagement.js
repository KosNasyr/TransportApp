$(function () {
    $("#addForm").submit(function () {
        var id = $("#id").val();
        var manager = $("#manager").val();
        var address = $("#address").val();
        var arr = {
            "id" : id,
            "manager": manager,
            "address": address
        };
        $.ajax({
            type: 'POST',
            url: '/TransportApp-1.0/api/management/add',
            contentType: 'application/json',
            dataType:'json',
            data: JSON.stringify(arr)
        });
    })
})

$(function () {
    $("#editForm").submit(function () {
        var id = $("#eid").val();
        var manager = $("#emanager").val();
        var address = $("#eaddress").val();
        var arr = {
            "id" : id,
            "manager": manager,
            "address": address
        };
        $.ajax({
            type: 'PUT',
            url: '/TransportApp-1.0/api/management/' + id,
            contentType: 'application/json',
            dataType:'json',
            data: JSON.stringify(arr)
        });
    })
})

$(function () {
    $("#deleteForm").submit(function () {
        var id = $("#did").val();
        $.ajax({
            type: 'DELETE',
            url: "/TransportApp-1.0/api/management/" + id
        });
    })
})

function print(jsondata){
    var text = "";
    text += jsondata.id + " / "
        + jsondata.manager + " / "
        + jsondata.address + "<br>";
    $("#out2").html("")
    $("#out2").append(text);
    $("#fid").val("");
}

$(function () {
    $("#getman").click(function () {
        var id = $("#fid").val();
        $.ajax ({
            type: "GET",
            url:"/TransportApp-1.0/api/management/" +id,
            datatype: "json",
            success:  function(jsondata) {
                print(jsondata)
            }
        })
    })
})