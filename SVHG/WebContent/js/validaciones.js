function solonumeros(e){
	key=e.keyCode || e.which;
	teclado=String.fromCharCode(key);
	numeros="1234567890";
	especiales="8-37-38-46";
	teclado_especial=false;
	for (var i in especiales){
		if(key==especiales[i]){
			teclado_especial=true;
		}
	}
	if(numeros.indexOf(teclado)==-1 && !teclado_especial){
		return false;
	}
}


function solonumerosCarr(e){
	key=e.keyCode || e.which;
	teclado=String.fromCharCode(key);
	numeros="123456789";
	especiales="8-37-38-46";
	teclado_especial=false;
	for (var i in especiales){
		if(key==especiales[i]){
			teclado_especial=true;
		}
	}
	if(numeros.indexOf(teclado)==-1 && !teclado_especial){
		return false;
	}
}


function sololetras(e){
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toLowerCase();
    letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
    especiales = "8-37-39-46";

    tecla_especial = false
    for(var i in especiales){
         if(key == especiales[i]){
             tecla_especial = true;
             break;
         }
     }

     if(letras.indexOf(tecla)==-1 && !tecla_especial){
         return false;
     }
 }


//VALIDAR ENTRADA DE ARCHIVOS A FILE 
function control(f){
    var ext=['gif','jpg','jpeg','png'];
    var v=f.value.split('.').pop().toLowerCase();
    for(var i=0,n;n=ext[i];i++){
        if(n.toLowerCase()==v)
            return
    }
    var t=f.cloneNode(true);
    t.value='';
    f.parentNode.replaceChild(t,f);
    alert("¡ARCHIVO INVALIDO, SELECCIONE OTRO!");;
}


//VALIDAR SOLO NUMEROS, 2 DECIMALES Y UN SOLO PUNTO DECIMAL
function NumCheck(e, field) {

	  key = e.keyCode ? e.keyCode : e.which

	  if (key == 8) return true

	  if (key > 47 && key < 58) {

	    if (field.value == "") return true

	    regexp = /.[0-9]{2}$/

	    return !(regexp.test(field.value))

	  }

	  // .

	  if (key == 46) {

	    if (field.value == "") return false

	    regexp = /^[0-9]+$/

	    return regexp.test(field.value)

	  }

	  return false

	}