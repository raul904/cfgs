//obre el modal
$( document ).ready(function() {
    $('#exampleModal').modal('show');
});



//instancia totes les clases
var partida = new Partida();

$( '.micheckbox' ).on( 'click', function() {
    
    if( $(this).is(':checked') ){
        // Hacer algo si el checkbox ha sido seleccionado
        partida.tamanyoTablero =$(this).val();
        $( '#play' ).prop("disabled",false);
      
       
    } else {
        // Hacer algo si el checkbox ha sido deseleccionado
        alert("Debes de selecionar un tamaño");
    }
});


var tabla = new Tauler();
var fitxa = new Fitxa();






 






