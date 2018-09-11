$(function () {
    $("#addForm").submit(function () {
        var id = $("#id").val();
        var tankAverage = $("#tankAverage").val();
        var capacity = $("#capacity").val();
        var driver = $("#driver").val();
        var registrationPlate = $("#registrationPlate").val();
        var arr = {
            "id" : id,
            "tankAverage" : tankAverage,
            "capacity" :  capacity,
            "driver" : driver,
            "registrationPlate" :  registrationPlate
        };
        $.ajax({
            type: 'POST',
            url: '/TransportApp-1.0/api/bus/add',
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
        var capacity = $("#ecapacity").val();
        var driver = $("#edriver").val();
        var registrationPlate = $("#eregistrationPlate").val();
        var arr = {
            "id" : id,
            "tankAverage" : tankAverage,
            "capacity" :  capacity,
            "driver" : driver,
            "registrationPlate" :  registrationPlate
        };
        $.ajax({
            type: 'PUT',
            url: '/TransportApp-1.0/api/bus/' + id,
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
            url: "/TransportApp-1.0/api/bus/" + id
        });
    })
})

function print(jsondata){
    var text = "";
    text += jsondata.id + " / "
        + jsondata.tankAverage + " / "
        + jsondata.capacity + " / "
        + jsondata.driver + " / "
        + jsondata.registrationPlate + "<br>";
    $("#out2").html("")
    $("#out2").append(text);
    $("#fid").val("");
}

$(function () {
    $("#getbus").click(function () {
        var id = $("#fid").val();
        $.ajax ({
            type: "GET",
            url:"/TransportApp-1.0/api/bus/" +id,
            datatype: "json",
            success:  function(jsondata) {
                print(jsondata)
            }
        })
    })
})