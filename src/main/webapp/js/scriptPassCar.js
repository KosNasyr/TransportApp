$(function () {
    $("#addForm").submit(function () {
        var id = $("#id").val();
        var tankAverage = $("#tankAverage").val();
        var driver = $("#driver").val();
        var registrationPlate = $("#registrationPlate").val();
        var arr = {
            "id" : id,
            "tankAverage" : tankAverage,
            "driver" : driver,
            "registrationPlate" :  registrationPlate
        };
        $.ajax({
            type: 'POST',
            url: '/TransportApp-1.0/api/passengercar/add',
            contentType: 'application/json',
            dataType:'json',
            data: JSON.stringify(arr)
        });
    })
})

$(function () {
    $("#editForm").submit(function () {
        var id = $("#eid").val();
        var tankAverage = $("#etankAverage").val();
        var driver = $("#edriver").val();
        var registrationPlate = $("#eregistrationPlate").val();
        var arr = {
            "id" : id,
            "tankAverage" : tankAverage,
            "driver" : driver,
            "registrationPlate" :  registrationPlate
        };
        $.ajax({
            type: 'PUT',
            url: '/TransportApp-1.0/api/passengercar/' + id,
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
            url: "/TransportApp-1.0/api/passengercar/" + id
        });
    })
})

function print(jsondata){
    var text = "";
    text += jsondata.id + " / "
        + jsondata.tankAverage + " / "
        + jsondata.driver + " / "
        + jsondata.registrationPlate + "<br>";
    $("#out2").html("")
    $("#out2").append(text);
    $("#fid").val("");
}

$(function () {
    $("#getpc").click(function () {
        var id = $("#fid").val();
        $.ajax ({
            type: "GET",
            url:"/TransportApp-1.0/api/passengercar/" +id,
            datatype: "json",
            success:  function(jsondata) {
                print(jsondata)
            }
        })
    })
})