

window.onload= function () {
    document.getElementById("imageOfData3").style.display="none";
    document.getElementById("imageOfData2").style.display="none";
    document.getElementById("imageOfData1").style.display="none"

}
function showDigitalNavigation() {
    document.getElementById("digitalNav").style.left="80px";

}
function hideDigtalNavigation() {
    document.getElementById("digitalNav").style.left="-250px";

}
function showDataNav() {
    document.getElementById("dataNav").style.left="80px";

}
function hideDataNav() {
    document.getElementById("dataNav").style.left="-250px";

}
function getDatafor(team) {
    console.log(team);
    if(team=="dataService"){
        setVisibilityforDS(),
        getDataforDataService();
    }
    if(team=="all"){
        setVisibiltyforall();
        getDataforAll();

    }
    if(team=="digital"){
        setVisibiltyforDigital();
        getDataforDigital();

    }

}
function setVisibiltyforDigital() {
    document.getElementById("heading").innerHTML="Digital";

}
function setVisibiltyforall() {
    document.getElementById("heading").innerHTML="LeaderBoard";
    document.getElementById("scoreCardDigital").style.display="block";
    document.getElementById("scoreCardDS").style.display="block";
    document.getElementById("RandR").style.display="block";
    document.getElementById("imageOfData3").style.display="none";
    document.getElementById("imageOfData2").style.display="none";
    document.getElementById("imageOfData1").style.display="none"

}
function setVisibilityforDS() {
    document.getElementById("heading").innerHTML="Data Services"
    document.getElementById("scoreCardDigital").style.display="none";
    document.getElementById("scoreCardDS").style.display="none";
    document.getElementById("RandR").style.display="none";
    document.getElementById("imageOfData3").style.display="block";
    document.getElementById("imageOfData2").style.display="block";
    document.getElementById("imageOfData1").style.display="block"
}
function getDataforAll(){
    document.getElementById("headCountVal").innerHTML=null;
    document.getElementById("headCount").innerHTML=null;
    document.getElementById("retentionVal").innerHTML=null;
    document.getElementById("attrition").innerHTML=null;
    document.getElementById("productivityVal").innerHTML=null;
    document.getElementById("productivity").innerHTML=null;
}
function getDataforDataService() {
    console.log(1)
    $.ajax({
        url:"http://localhost:8080/get",
        type:"get",
        dataType:"json",
        headers: {
            'Content-Type': 'application/json'
        },
        success:function (result) {
            console.log(result)
            headcountJson={"DDX":result["ddxPojo"].headcount,
                        "IA":result["iaPojo"].headcount,
                        "ICAP":result["icapPojo"].headcount,
                        "3PA":result["threePAPojo"].headcount};

            productivitysJson={"DDX":result["ddxPojo"].productivity,
                "IA":result["iaPojo"].productivity,
                "ICAP":result["icapPojo"].productivity,
                "3PA":result["threePAPojo"].productivity

            };
            attritionJSON={"RetentionRate":result["attritionPojo"].retentionRate,
                            "AttritionRate":result["attritionPojo"].attritionRate

            };

            generateHeadCountChart(headcountJson);
            generateProductivityChart(productivitysJson);
            generateAttritionChart(attritionJSON);


        },
        error:function (result) {
          console.log(result)

        }

    })

}
function generateHeadCountChart(g) {
    setTotalheadCount(g);
    var chart = c3.generate({
        bindto: '#headCount',
        data: {
            json: g,
            size: {
                height: 200,
                width: 200
            },
            type: 'pie'

        },
        color: {
            pattern: ["#f2574d","#f9e55b","#30d170","#3295de"]
        },
        pie: {
            label: {
            show:false,
            },
            zoom: {
                enabled: true,
            },
            legend: {
                postion: 'bottom',
            }

        },
        tooltip: {
            format: {
                value: function (value, ratio, id) {
                    return value;
                }
//            value: d3.format(',') // apply this format to both y and y2
            }
        }

    });
}


function generateAttritionChart(attritionData) {
    setAttritionValue(attritionData);
    var chart = c3.generate({
        bindto: '#attrition',
        data: {
            json: attritionData,
            size: {
                height: 200,
                width: 200
            },
            type: 'pie'

        },
        color: {
            pattern: ["#30d170","#f2574d"]
        },
        pie: {
            label: {
                show:false,

            },
            zoom: {
                enabled: true,
            },
            legend: {
                postion: 'bottom',
            }
        }
    });
}


function generateProductivityChart(productivityData){
    setTotalProductivityVal(productivityData)
    var chart = c3.generate({
        bindto:"#productivity",
        data: {
            json:productivityData,
            type : 'pie',
        },

        color: {
            pattern: ["#f2574d","#f9e55b","#30d170","#3295de"]
        },
        pie: {
            label: {
               show:false

            }
        },
        legend:{
            postion:'bottom',
        },
        tooltip: {
            format: {
                value: function (value, ratio, id) {
                   return value;
                }
//            value: d3.format(',') // apply this format to both y and y2
            }
    }});
}
function generateScorecard(scoreCardData) {
    var chart = c3.generate({
        bindto:"#scoreCard",
        data: {
            json:scoreCardData,
            type : 'donut',
            onclick: function (d, i) { console.log("onclick", d, i); },
            onmouseover: function (d, i) { console.log("onmouseover", d, i); },
            onmouseout: function (d, i) { console.log("onmouseout", d, i); }
        },
        donut: {
            label: {
                // format: function(value, ratio, id) {
                //     return value;
                // }
                show:false,
            }
        }

    });


}
function setTotalheadCount(data){
    console.log(data);
    var totalheadcount=0;
    var keyNames=Object.keys(data);
        for(i in keyNames)
    {   console.log(keyNames[i])
        totalheadcount+=data[keyNames[i]];
    }
    document.getElementById("headCountVal").innerHTML=totalheadcount;
}
function setTotalProductivityVal(data){
    console.log(data);
    var totalProductivity=0;
    var keyNames=Object.keys(data);
    for(i in keyNames)
    {   console.log(keyNames[i])
        totalProductivity+=data[keyNames[i]];
    }
    document.getElementById("productivityVal").innerHTML=totalProductivity;
}
function setAttritionValue(data) {
    document.getElementById("retentionVal").innerHTML = data["RetentionRate"] + "<span>%</span>"
}
    



