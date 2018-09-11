var textman = "";
var textcar = "";
var textbus = "";
var texttruck = "";

function print(jsondata) {
        for (var key in jsondata) {
            if (typeof jsondata[key] == "object" && jsondata[key] !== null) {
                print(jsondata[key])
                if (jsondata[key].type === "MANAGEMENT") {
                    textman += jsondata[key].id + " / "
                        + jsondata[key].manager + " / "
                        + jsondata[key].address + "<br>";
                }
                else if (jsondata[key].type === "PASSENGER_CAR") {
                    textcar += jsondata[key].id + " / "
                        + jsondata[key].tankAverage + " / "
                        + jsondata[key].driver + " / "
                        + jsondata[key].registrationPlate + "<br>";
                }
                else if (jsondata[key].type === "BUS") {
                    textbus += jsondata[key].id + " / "
                        + jsondata[key].tankAverage + " / "
                        + jsondata[key].capacity + " / "
                        + jsondata[key].driver + " / "
                        + jsondata[key].registrationPlate + "<br>";

                }
                else if (jsondata[key].type === "TRUCK") {
                    texttruck += jsondata[key].id + " / "
                        + jsondata[key].tankAverage + " / "
                        + jsondata[key].cargo + " / "
                        + jsondata[key].driver + " / "
                        + jsondata[key].registrationPlate + "<br>";
                }
            }
        }
}



$(function () {
    $("#getdata").click(function () {
        $.ajax ({
            type: "GET",
            url:"/TransportApp-1.0/api/hierarchy/tree",
            datatype: "json",
            success:  function(jsondata) {
                print(jsondata);
                $("#out").html("");
                $("#out").append("MANAGEMENT" + "<br>");
                $("#out").append("ID  /  Manager  /  Address" + "<br>");
                $("#out").append(textman);
                $("#out").append("ALL PASSENGER CARS" + "<br>");
                $("#out").append("ID  /  TankAverage  /  Driver  /  RegistrationPlate" + "<br>");
                $("#out").append(textcar);
                $("#out").append("ALL BUSES" + "<br>");
                $("#out").append("ID  /  TankAverage  /  Capacity  /  Driver  /  RegistrationPlate" + "<br>");
                $("#out").append(textbus);
                $("#out").append("ALL TRUCKS" + "<br>");
                $("#out").append("ID  /  TankAverage  /  Cargo  /  Driver  /  RegistrationPlate" + "<br>");
                $("#out").append(texttruck);
                textman = "";
                textcar = "";
                textbus = "";
                texttruck = "";
            }
        })
    })
})
