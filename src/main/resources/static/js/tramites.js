$(document).ready(function() {

    $("input[id^='filter-']").on('input', function() {

        var id = $("#filter-id").val();
        var codigo = $("#filter-codigo").val();
        var nombre = $("#filter-nombre").val();
        var numero_comprobante = $("#filter-numero-comprobante").val();
        var resumen = $("#filter-resumen").val();
        var monto = $("#filter-monto").val();


        $.get("/tramite/find", { id: id, codigo: codigo ,nombre: nombre, numero_comprobante:numero_comprobante,resumen:resumen ,monto:monto}, function(data) {
            // Actualiza la tabla con los datos devueltos
            // Debes personalizar este código dependiendo de la estructura de los datos devueltos
            $("tbody").empty();
            data.forEach(function(tramite) {
                var row = "<tr>" +
                    "<td>" + tramite.id + "</td>" +
                    "<td>" + tramite.codigo + "</td>" +
                    "<td>" + tramite.nombre + "</td>" +
                    "<td>" + tramite.numeroComprobante + "</td>" +
                    "<td>" + tramite.resumen + "</td>" +
                    "<td>" + tramite.monto + "</td>" +
                    "<td>" + tramite.fechaConclusion + "</td>" +
                    "<td>" + tramite.vinculoDocumentoDigital + "</td>" +
                    "</tr>";
                $("tbody").append(row);
            });
        });
    });
});