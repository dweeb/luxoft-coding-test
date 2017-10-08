/**
 * Created by iussov on 08.10.2017.
 */
var type = "Forward";
var array = [];

$(document).ready(function(){

    $("#clear").click(function () {
        $("#records").html("<tr><td>TCN</td><td>Type</td><td>Error</td></tr>");
        array.length = 0;
    });

    $("#validate").click(function () {
        $.ajax({
            url: "validate",
            type: "POST",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(array),
            success: function(data, textStatus) {
                $("#records").html("<tr><td>TCN</td><td>Type</td><td>Error</td></tr>");
                $.each(data, function(i, val) {
                    var errorMessage = "";
                    $.each(val.errorMessage, function (n, error) {
                        errorMessage += error + ". ";
                    });
                    $("#records").append("<tr><td>" + val.tcn + "</td><td>"
                        + val.type + "</td><td>" + errorMessage + "</td></tr>");
                });
            },
            error: function() {
                alert("error happened");
            },
        });

    });
    
    $("#add").click(function () {
        var tcn = $("#TCN").val();
        if (tcn.length == 0) {
            return;
        }
        var str = "<tr><td>" + tcn + "</td><td>" + type + "</td><td></td></tr>";
        $("#records").append(str);
        var record = {};
        $("#form input").each(function () {
            record[$(this).attr("id")] = $(this).val();
        });
        record.type = type;
        array.push(record);
    });

    $("#type").change(function(){
        var str = "";
        $( "#type option:selected" ).each(function() {
            type = $(this).text();
        });
        if (type == "Spot") {
            str = '<table>' +
                '<tr><td>TCN</td><td><input id="TCN" type="text"/></td><td></td></tr>' +
                '<tr><td>customer</td><td><input id="customer" type="text"/></td><td></td></tr>' +
                '<tr><td>ccyPair</td><td><input id="ccyPair" type="text"/></td><td>example EURUSD</td></tr>' +
                '<tr><td>direction</td><td><input id="direction" type="text"/></td><td></td></tr>' +
                '<tr><td>tradeDate</td><td><input id="tradeDate" type="text"/></td><td>YYYY-MM-DD</td></tr>' +
                '<tr><td>amount1</td><td><input id="amount1" type="text"/></td><td></td></tr>' +
                '<tr><td>amount2</td><td><input id="amount2" type="text"/></td><td></td></tr>' +
                '<tr><td>rate</td><td><input id="rate" type="text"/></td><td></td></tr>' +
                '<tr><td>valueDate</td><td><input id="valueDate" type="text"/></td><td>YYYY-MM-DD</td></tr>' +
                '<tr><td>legalEntity</td><td><input id="legalEntity" type="text"/></td><td></td></tr>' +
                '<tr><td>trader</td><td><input id="trader" type="text"/></td><td></td></tr>' +
                '</table>';
        }
        if (type == "Forward") {
            str = '<table>' +
                '<tr><td>TCN</td><td><input id="TCN" type="text"/></td><td></td></tr>' +
                '<tr><td>customer</td><td><input id="customer" type="text"/></td><td></td></tr>' +
                '<tr><td>ccyPair</td><td><input id="ccyPair" type="text"/></td><td>example EURUSD</td></tr>' +
                '<tr><td>direction</td><td><input id="direction" type="text"/></td><td></td></tr>' +
                '<tr><td>tradeDate</td><td><input id="tradeDate" type="text"/></td><td>YYYY-MM-DD</td></tr>' +
                '<tr><td>amount1</td><td><input id="amount1" type="text"/></td><td></td></tr>' +
                '<tr><td>amount2</td><td><input id="amount2" type="text"/></td><td></td></tr>' +
                '<tr><td>rate</td><td><input id="rate" type="text"/></td><td></td></tr>' +
                '<tr><td>valueDate</td><td><input id="valueDate" type="text"/></td><td>YYYY-MM-DD</td></tr>' +
                '<tr><td>legalEntity</td><td><input id="legalEntity" type="text"/></td><td></td></tr>' +
                '<tr><td>trader</td><td><input id="trader" type="text"/></td><td></td></tr>' +
                '</table>';
        }
        if (type == "VanillaOption") {
            str = '<table>' +
                '<tr><td>TCN</td><td><input id="TCN" type="text"/></td><td></td></tr>' +
                '<tr><td>customer</td><td><input id="customer" type="text"/></td><td></td></tr>' +
                '<tr><td>ccyPair</td><td><input id="ccyPair" type="text"/></td><td>example EURUSD</td></tr>' +
                '<tr><td>style</td><td><input id="style" type="text"/></td><td></td></tr>' +
                '<tr><td>direction</td><td><input id="direction" type="text"/></td><td></td></tr>' +
                '<tr><td>strategy</td><td><input id="strategy" type="text"/></td><td></td></tr>' +
                '<tr><td>tradeDate</td><td><input id="tradeDate" type="text"/></td><td>YYYY-MM-DD</td></tr>' +
                '<tr><td>amount1</td><td><input id="amount1" type="text"/></td><td></td></tr>' +
                '<tr><td>amount2</td><td><input id="amount2" type="text"/></td><td></td></tr>' +
                '<tr><td>rate</td><td><input id="rate" type="text"/></td><td></td></tr>' +
                '<tr><td>deliveryDate</td><td><input id="deliveryDate" type="text"/></td><td>YYYY-MM-DD</td></tr>' +
                '<tr><td>expiryDate</td><td><input id="expiryDate" type="text"/></td><td>YYYY-MM-DD</td></tr>' +
                '<tr><td>excerciseStartDate</td><td><input id="excerciseStartDate" type="text"/></td><td>YYYY-MM-DD</td></tr>' +
                '<tr><td>payCcy</td><td><input id="payCcy" type="text"/></td><td></td></tr>' +
                '<tr><td>premium</td><td><input id="premium" type="text"/></td><td></td></tr>' +
                '<tr><td>premiumCcy</td><td><input id="premiumCcy" type="text"/></td><td></td></tr>' +
                '<tr><td>premiumType</td><td><input id="premiumType" type="text"/></td><td></td></tr>' +
                '<tr><td>legalEntity</td><td><input id="legalEntity" type="text"/></td><td></td></tr>' +
                '<tr><td>trader</td><td><input id="trader" type="text"/></td><td></td></tr>' +
                '</table>';
        }
        if (type == "Risk") {
            str = '<table>' +
                '<tr><td>TCN</td><td><input id="TCN" type="text"/></td><td></td></tr>' +
                '<tr><td>CCY</td><td><input id="CCY" type="text"/></td><td></td></tr>' +
                '<tr><td>PV</td><td><input id="PV" type="text"/></td><td></td></tr>' +
                '</table>';
        }
        $("#form").html(str);
    });

});