function addEvent(obj, type, fn){
	if (obj.addEventListener)
		obj.addEventListener(type, fn, false);
	else if (obj.attachEvent){
		obj["e"+type+fn] = fn;
		obj[type+fn] = function() { obj["e"+type+fn]( window.event ); }
		obj.attachEvent( "on"+type, obj[type+fn] );
	}
}

function verificarExibirArea(obj, valueAreaMap) {
	if(!obj || !obj.value)
		return;
	for(var key in valueAreaMap) {
		if(obj.value == key) {
			document.getElementById(valueAreaMap[key]).style.display = '';
		} else {
			document.getElementById(valueAreaMap[key]).style.display = 'none';
		}
	}
}
function exibirAreas(objName, valueAreaMap) {
	var els = document.getElementsByName(objName);
	if(els.length == 1) {
		verificarExibirArea(els[0], valueAreaMap);
	} else {
		for(var i = 0; i < els.length; ++i) {
			var obj = els[i];
			addEvent(obj, 'click', function() {
				verificarExibirArea(this, valueAreaMap);
			});
			if(obj.checked) {
				verificarExibirArea(obj, valueAreaMap);
			}
		}
	}
}
function configurarExibicaoCondicional(objName, valueAreaMap) {
	addEvent(window, 'load', function() {
		exibirAreas(objName, valueAreaMap);
	});
}


function ativarCombo(item){
	
	var newItem = document.getElementById(item);
	var array = document.getElementsByTagName('select');
	
	for(var i=0; i< array.length; i++){
		if(array[i].name.substring(0,4) == 'item'){
			array[i].disabled = true;
			array[i].selectedIndex = 0;
		} 
	}
	newItem.disabled=false;
}
function atribuirRadioAoCampoHidden(radioValue, comboValue, anoContrato){
	var numContratoHidden = document.getElementById('form1:numeroContratoHiddenGambiarra');
	numContratoHidden.value = radioValue;
	var numItemContratoHidden = document.getElementById('form1:numeroItemContratoHiddenGambiarra');
	numItemContratoHidden.value = comboValue;
	var anoContratoHidden = document.getElementById('form1:anoContratoHiddenGambiarra');
	anoContratoHidden.value = anoContrato;
}
function atribuirHiddenAoRadio(numContrato,numItemContrato){
	// TODO
	// alert(numContrato + ' ' + numItemContrato);
	// alert(document.getElementById('form1:items'));
    // var radioButtonName = "form1:table1:"+rowId+":radio1";
	// for(i=0; i < listaContratos.length; i++){
		/*
		 * var frase = listaContratos.elements[i].name+""; if(frase ==
		 * numContrato){ radioButtonName = "form1:table1:"+rowId+":radio1";
		 * //Deselect all radio buttons first(if this element is a radio button
		 * inside your datatable) if(listaContratos.elements[i].name ==
		 * radioButtonName){ listaContratos.elements[i].checked = false; } }
		 */
	// }
	// document.getElementById('form1:items').value = numContrato;
	// document.getElementById('form1:item'+numContrato).selectedIndex =
	// numItemContrato;
}
// function atribuirValorInputFavorecido(inputRadio){ ----- Comented by Victor
// /*
// Atribui o valor dos campos hidden do popUp aos campos txtFavorecido e
// nomeFavorecido,
// no momento que o usuario clica no radio button do popup.
//		
// Valido apenas para o popup Favorecido
// */
// var campoSelecionado = inputRadio.name;
// var prefixo = "form1:table1:";
// var sufixo = ":radio1";
//	
// campoSelecionado = campoSelecionado.replace(prefixo,"");
// campoSelecionado = campoSelecionado.replace(sufixo,"");
//
// var nome = document.getElementById(prefixo + campoSelecionado + ":nome");
// var numcpfcnpj = document.getElementById(prefixo + campoSelecionado +
// ":numerocpfcnpj");
//	
// window.parent.opener.document.getElementById('form1:txtFavorecido').value =
// numcpfcnpj.value;
// window.parent.opener.document.getElementById('form1:nomeFavorecido').value =
// nome.value;
// window.parent.opener.document.getElementById('form1:nomeFavorecido').style.color
// = "black";
// window.parent.opener.document.getElementById('form1:nomeFavorecido').style.fontWeight
// = "normal";
// }
function selectComboById(valor,field) {

	var combo = document.getElementById(field);
	for (var i=0; i<combo.length; i++) {
		if (parseFloat(combo.options[i].value) == parseFloat(valor)) {
			combo.selectedIndex = i;
			return;
		}
	}
	combo.selectedIndex = 0;
}
function atribuirValorRadio(idCampoCodigo,idCampoDesc,radio,campoPopUpId,campoPopUpDescricao){

	/*
	 * Funcao que atribui os valores do popup ao campo texto e combo
	 */
	
	var prefixo = "form1:table1:";
	var sufixo = ":radio1";
	
	radio = radio.replace(prefixo,"");
	radio = radio.replace(sufixo,"");
	
	
	var id = document.getElementById(prefixo + radio + ":"+campoPopUpId).value;
	var descricao = document.getElementById(prefixo + radio + ":"+campoPopUpDescricao).value;
	
	// Atribui codigo do registro a um input text ou input hidden na janela do
	// opener
	window.parent.opener.document.getElementById(idCampoCodigo).value = id;
	
	// Atribui a descriï¿½ï¿½o do registro a um input ou combo
	var campoDesc = window.parent.opener.document.getElementById(idCampoDesc);
	if(campoDesc != undefined ){
		
		// Caso campo seja um combo
		if(campoDesc.type == 'select-one'){
			for (var i=0; i<campoDesc.length; i++) {
				if (parseFloat(campoDesc.options[i].value) == parseFloat(id)) {
					campoDesc.selectedIndex = i;
					return;
				}
			}
			campoDesc.selectedIndex = 0;
			
		// Caso campo seja um input
		}else if(campoDesc.type == 'text' || campoDesc.type == 'hidden'){
			campoDesc.value = descricao;
		}
	}
	
}
function exibirSumirDadosConta(combo) {
	/*
	 * Funcao que exibe ou apaga os dados da conta no formulario, caso o codigo
	 * da "forma de pagamento" seja 1 ou 8, esses campos serï¿½o ativados
	 */
	var vr = combo.options[combo.selectedIndex].value;

	if (vr == '1' || vr == '8') {
		var elem = document.getElementById('dadosContaHidden');
		elem.style.display = 'block';
		document.getElementById('form1:edtBancoCredito').value = '';
		document.getElementById('form1:edtAgenciaCredito').value = '';
		document.getElementById('form1:edtContaCredito').value = '';
	} else {
		var elem = document.getElementById('dadosContaHidden');
		elem.style.display = 'none';
	}

}

function select1_onchange() {
	var sel =document.getElementById('form1:tipoTransacao');
	if (sel.value == 0) {
		var elem = document.getElementById('desp');
		elem.style.display = 'none';
		var elem2 = document.getElementById('dep');
		elem2.style.display = 'none';
	}
	if (sel.value == 1) {
		var elem = document.getElementById('desp');
		elem.style.display = 'block';
		var elem2 = document.getElementById('dep');
		elem2.style.display = 'none';
	}
	if (sel.value == 2) { 
		var elem = document.getElementById('dep');
		elem.style.display = 'block';
		var elem2 = document.getElementById('desp');
		elem2.style.display = 'none';
	}
}
function FormataConta(campo, teclapres) {
	var tecla = teclapres.keyCode;

	if((tecla<48 || (tecla>57 && tecla<96) || tecla>105) && tecla!=16 && tecla!=17 && tecla!=8 && tecla!=46) {
		teclapres.keyCode=0;		
		return false;
	}
}

/**
 * Criado para formatar campos de valores percentuais.
 */
function FormataValorTaxa(campo,e){
	//Inicialmente verifica se a tecla pressionada e valida
	//um recurso diferente de caracter.
	if(!somenteNumero(event)){
		return false;
	}
	if(campo.value.length == campo.maxLength ){
		return false;
	}else{
		return FormataValor(campo,e);
	}
}

function FormataValor(campo, teclapres) {

	// Não formata campos marcado como somente leitura.

	if(campo.readOnly){
		return false;
	}
	
	var tecla = teclapres.keyCode;
	
	// Esta é a tecla shift ( importante para evitar caracteres especiais)
	if(tecla == 16){
		return false;
	}
	
	if(tecla == 9){return true;}
	if((tecla<48 || (tecla>57 && tecla<96) || tecla>105) && tecla!=16 && tecla!=17 && tecla!=8 && tecla!=46) {
		// teclapres.keyCode=0;
		return false;
	}
	if(tecla==46){
		campo.value = campo.value.substr(0,campo.value.length-1);
	}

	var tammax = 15;
	var vr = campo.value;
	vr = vr.replace( "/", "" );
	vr = vr.replace( "/", "" );
	vr = vr.replace( ",", "" );
	vr = vr.replace( ".", "" );
	vr = vr.replace( ".", "" );
	vr = vr.replace( ".", "" );
	
	// Modificacao para remover caracteres inválidos
	vr = vr.replace(/\D/g,"");
	
	tam = vr.length;
	if (tam < tammax && tecla != 8){ tam = vr.length + 1 ; }
	if (tecla == 8 ){	tam = tam - 1 ; }
	if ( tecla == 8 || tecla >= 48 && tecla <= 57 || tecla >= 96 && tecla <= 105 ){
		if ( tam <= 2 ){ 
	 		campo.value = vr ; }
	 	if ( (tam > 2) && (tam <= 5) ){
	 		campo.value = vr.substr( 0, tam - 2 ) + ',' + vr.substr( tam - 2, tam ) ; }
	 	if ( (tam >= 6) && (tam <= 8) ){
	 		campo.value = vr.substr( 0, tam - 5 ) + '.' + vr.substr( tam - 5, 3 ) + ',' + vr.substr( tam - 2, tam ) ; }
	 	if ( (tam >= 9) && (tam <= 11) ){
	 		campo.value = vr.substr( 0, tam - 8 ) + '.' + vr.substr( tam - 8, 3 ) + '.' + vr.substr( tam - 5, 3 ) + ',' + vr.substr( tam - 2, tam ) ; }
	 	if ( (tam >= 12) && (tam <= 14) ){
	 		campo.value = vr.substr( 0, tam - 11 ) + '.' + vr.substr( tam - 11, 3 ) + '.' + vr.substr( tam - 8, 3 ) + '.' + vr.substr( tam - 5, 3 ) + ',' + vr.substr( tam - 2, tam ) ; }
	 	if ( (tam >= 15) && (tam <= 17) ){
	 		campo.value = vr.substr( 0, tam - 14 ) + '.' + vr.substr( tam - 14, 3 ) + '.' + vr.substr( tam - 11, 3 ) + '.' + vr.substr( tam - 8, 3 ) + '.' + vr.substr( tam - 5, 3 ) + ',' + vr.substr( tam - 2, tam ) ;}
	}
}

function FormataValorQuatroCasas(campo, teclapres) {

	// Não formata campos marcado como somente leitura.

	if(campo.readOnly){
		return false;
	}

	var tecla = teclapres.keyCode;
	
	// Esta é a tecla shift ( importante para evitar caracteres especiais)
	if(tecla == 16){
		return false;
	}
	
	if(tecla == 9){return true;}
	if((tecla<48 || (tecla>57 && tecla<96) || tecla>105) && tecla!=16 && tecla!=17 && tecla!=8 && tecla!=46) {
		// teclapres.keyCode=0;
		return false;
	}
	if(tecla==46){
		campo.value = campo.value.substr(0,campo.value.length-1);
	}

	var tammax = 15;
	var vr = campo.value;
	vr = vr.replace( "/", "" );
	vr = vr.replace( "/", "" );
	vr = vr.replace( ",", "" );
	vr = vr.replace( ".", "" );
	vr = vr.replace( ".", "" );
	vr = vr.replace( ".", "" );
	
	// Modificacao para remover caracteres inválidos
	vr = vr.replace(/\D/g,"");
	
	tam = vr.length;
	if (tam < tammax && tecla != 8){ tam = vr.length + 1 ; }
	if (tecla == 8 ){	tam = tam - 1 ; }
	if ( tecla == 8 || tecla >= 48 && tecla <= 57 || tecla >= 96 && tecla <= 105 ){
		if ( tam <= 4 ){ 
	 		campo.value = vr ; }
	 	if ( (tam > 4) && (tam <= 7) ){
	 		campo.value = vr.substr( 0, tam - 4 ) + ',' + vr.substr( tam - 4, tam ) ; }
	 	if ( (tam >= 8) && (tam <= 10) ){
	 		campo.value = vr.substr( 0, tam - 7 ) + '.' + vr.substr( tam - 7, 3 ) + ',' + vr.substr( tam - 4, tam ) ; }
	 	if ( (tam >= 11) && (tam <= 13) ){
	 		campo.value = vr.substr( 0, tam - 10 ) + '.' + vr.substr( tam - 10, 3 ) + '.' + vr.substr( tam - 7, 3 ) + ',' + vr.substr( tam - 4, tam ) ; }
	 	if ( (tam >= 14) && (tam <= 16) ){
	 		campo.value = vr.substr( 0, tam - 13 ) + '.' + vr.substr( tam - 13, 3 ) + '.' + vr.substr( tam - 10, 3 ) + '.' + vr.substr( tam - 7, 3 ) + ',' + vr.substr( tam - 4, tam ) ; }
	 	if ( (tam >= 17) && (tam <= 19) ){
	 		campo.value = vr.substr( 0, tam - 16 ) + '.' + vr.substr( tam - 16, 3 ) + '.' + vr.substr( tam - 13, 3 ) + '.' + vr.substr( tam - 10, 3 ) + '.' + vr.substr( tam - 7, 3 ) + ',' + vr.substr( tam - 4, tam ) ;
	 	}
	}
}
function FormataCpfCnpj(campo, teclapres) {
	
	var tecla = teclapres.keyCode;
	if(tecla == 9){return true;}
	if((tecla<48 || (tecla>57 && tecla<96) || tecla>105) && tecla!=16 && tecla!=17 && tecla!=8 && tecla!=46){
		teclapres.keyCode=0;		
		return false;
	}
	if(tecla==46){
		campo.value = campo.value.substr(0,campo.value.length-1);
	}
	var tammax = 15;
	var vr = campo.value;
	vr = vr.replace( "/", "" );
	vr = vr.replace( "/", "" );
	vr = vr.replace( ",", "" );
	vr = vr.replace( ".", "" );
	vr = vr.replace( ".", "" );
	vr = vr.replace( ".", "" );
	vr = vr.replace( ".", "" );
	vr = vr.replace( "-", "" );
	tam = vr.length;
	if (tam >= 14) {
		// teclapres.keyCode=0; cï¿½digo comentado, pois ao digitar todos os
		// dï¿½gitos e apertar a tecla ctrl, ocorria um erro
		return false;
	}
	if (tam < tammax && tecla != 8){ tam = vr.length + 1 ; }
	if (tecla == 8 ){	tam = tam - 1 ; }
	if ( tecla == 8 || tecla >= 48 && tecla <= 57 || tecla >= 96 && tecla <= 105 ){
		if ( tam <= 2 ){ 
	 		campo.value = vr ; }
	 	if ( (tam > 2) && (tam <= 5) ){
	 		campo.value = vr.substr( 0, tam - 2 ) + '-' + vr.substr( tam - 2, tam ) ; }
	 	if ( (tam >= 6) && (tam <= 8) ){
	 		campo.value = vr.substr( 0, tam - 5 ) + '.' + vr.substr( tam - 5, 3 ) + '-' + vr.substr( tam - 2, tam ) ; }
	 	if ( (tam >= 9) && (tam <= 11) ){
	 		campo.value = vr.substr( 0, tam - 8 ) + '.' + vr.substr( tam - 8, 3 ) + '.' + vr.substr( tam - 5, 3 ) + '-' + vr.substr( tam - 2, tam ) ; }
	 	if ( (tam >= 12) && (tam <= 14) ){
	 		campo.value = vr.substr( 0, tam - 12 ) + '.' + vr.substr( tam - 12, 3 ) + '.' + vr.substr( tam - 9, 3 ) + '/' + vr.substr( tam - 6, 4 ) + '-' + vr.substr( tam - 2, tam ) ; }
		if ( (tam >= 15) && (tam <= 17) ){
	 		campo.value = vr.substr( 0, tam - 15 ) + '.' + vr.substr( tam - 15, 3 ) + '.' + vr.substr( tam - 14, 3 ) + '.' + vr.substr( tam - 11, 3 ) + '.' + vr.substr( tam - 8, 3 ) + '.' + vr.substr( tam - 5, 3 ) + ',' + vr.substr( tam - 2, tam ) ;}	 		
	}
}

// Evento SEDE ï¿½ formado por atï¿½ 5 digitos e um digito verificador
// 01234-5
function FormataEventoSEDE(campo, teclapres) {
	
	var tecla = teclapres.keyCode;
	if(tecla == 9){return true;}
	if((tecla<48 || (tecla>57 && tecla<96) || tecla>105) && tecla!=16 && tecla!=17 && tecla!=8 && tecla!=46){
		// teclapres.keyCode=0;
		return false;
	}
	if(tecla==46){
		campo.value = campo.value.substr(0,campo.value.length-1);
	}
	var tammax = 7;
	var vr = campo.value;
	vr = vr.replace( "/", "" );
	vr = vr.replace( "/", "" );
	vr = vr.replace( ",", "" );
	vr = vr.replace( ".", "" );
	vr = vr.replace( ".", "" );
	vr = vr.replace( ".", "" );
	vr = vr.replace( ".", "" );
	vr = vr.replace( "-", "" );
	tam = vr.length;
	if (tam >= 7) {
		// teclapres.keyCode=0; cï¿½digo comentado, pois ao digitar todos os
		// dï¿½gitos e apertar a tecla ctrl, ocorria um erro
		return false;
	}
	if (tam < tammax && tecla != 8){ tam = vr.length + 1 ; }
	if (tecla == 8 ){	tam = tam - 1 ; }
	if ( tecla == 8 || tecla >= 48 && tecla <= 57 || tecla >= 96 && tecla <= 105 ){
		if ( tam <= 2 ){ 
	 		campo.value = vr ; }
	 	if ( (tam > 1) && (tam <= 6) ){
	 		campo.value = vr.substr( 0, tam - 1 ) + '-' + vr.substr( tam - 1, tam ) ; }
	}
	return true;
}
	
	/**
	 * Funï¿½ï¿½o utilizada para desmarcar os demais radios de um grupo de
	 * radio, exceto o que foi clicado.
	 * 
	 */
	function radioButtonClick(radio) {
		
		var nome = radio.name.split(':');
		
		var i= nome[2];
		if(document.all){// Se for IE
			do{
				var radioAux = document.getElementsByName(nome[0]+':'+nome[1]+':'+i+':'+nome[3]);
				if(radioAux.length > 0){
					radioAux[1].checked = false;
				}
				i++;
			} while (radioAux.length > 0);
		
			i= nome[2];
			do{
				var radioAux = document.getElementsByName(nome[0]+':'+nome[1]+':'+i+':'+nome[3]);
				if(radioAux.length > 0){
					radioAux[1].checked = false;
				}
				i--;
			} while (radioAux.length > 0);
		
			radio.checked = true;
		}else{// Se nï¿½o for IE
			do{
				var radioAux = document.getElementsByName(nome[0]+':'+nome[1]+':'+i+':'+nome[3]);
				if(radioAux.length > 0){
					radioAux[0].checked = false;
				}
				i++;
			} while (radioAux.length > 0);
		
			i= nome[2];
			do{
				var radioAux = document.getElementsByName(nome[0]+':'+nome[1]+':'+i+':'+nome[3]);
				if(radioAux.length > 0){
					radioAux[0].checked = false;
				}
				i--;
			} while (radioAux.length > 0);
		
			radio.checked = true;
		}
	}
	
	
	/**
	 * 
	 * 
	 */
	function mascaraCpfCnpj(campo) {
		var s = new String(campo.value);
		// Remove todos os caracteres ï¿½ seguir: ( ) / - . e espaï¿½o, para
		// tratar
		// a string denovo.
		s = s.replace(/(\.|\(|\)|\/|\-| )+/g,'');
	 
		var tam = s.length + 1;
	 
		if (campo.length == 11) {
				if (tam > 3 && tam < 7)
					campo.value = s.substr(0,3) + '.' + s.substr(3, tam);
				if (tam >= 7 && tam < 10)
					campo.value = s.substr(0,3) + '.' + s.substr(3,3) + '.' + s.substr(6,tam-6);
				if (tam >= 10 && tam < 12)
					campo.value = s.substr(0,3) + '.' + s.substr(3,3) + '.' + s.substr(6,3) + '-' + s.substr(9,tam-9);
		}else if(campo.length == 15){
				if (tam > 2 && tam < 6)
					campo.value = s.substr(0,2) + '.' + s.substr(2, tam);
				if (tam >= 6 && tam < 9)
					campo.value = s.substr(0,2) + '.' + s.substr(2,3) + '.' + s.substr(5,tam-5);
				if (tam >= 9 && tam < 13)
					campo.value = s.substr(0,2) + '.' + s.substr(2,3) + '.' + s.substr(5,3) + '/' + s.substr(8,tam-8);
				if (tam >= 13 && tam < 15)
					campo.value = s.substr(0,2) + '.' + s.substr(2,3) + '.' + s.substr(5,3) + '/' + s.substr(8,4)+ '-' + s.substr(12,tam-12);
			}
		}
		
		// Funcao que permite que o evento
		// receba somente numeros para um determinado campo
		function somenteNumero(e){
	    	var tecla=(window.event)?e.keyCode:e.which;
	    	if ((tecla >= 48 && tecla <= 57)){
	    		return true;
	    	}else{
	    		if(tecla == 0 || tecla == 8 || tecla == 9){
	    			return true;    		
	    		} else {
			        return false;
	
	    		}
	    	}
		}
		
		/* Funï¿½ï¿½o configurada para o evento onkeypress */
		function somenteDelBackSpace(e){
	    	var tecla=(window.event)?e.keyCode:e.which;
    		if(tecla == 8 || tecla == 0){
    			return true;    		
    		} else {
		        return false;
    		}
		}
		
	/** Formata datas no formato MM/YYYY * */
	function FormataMesAnoComBarra(objeto,e) {
		var tecla=(window.event)?e.keyCode:e.which;
	    	 if ((tecla >= 48 && tecla <= 57)){
    			if (objeto.value.length == 2 && objeto.value.substring(0,1)!="/" && objeto.value.substring(1,2)!="/"){
					objeto.value = objeto.value+"/";
				}
	    		return true;
	    	}else{
	    		if(tecla == 0 || tecla == 8 || tecla == 9 || tecla == 46 || tecla == 32 || tecla == 37 || tecla == 39){
	    			return true;   	
	    		} else {
			        return false;
	
	    		}
	    	}
	}
		
	function getRadioValue(id){
		var count = 0;
		var firstRadioButtonName = "form1:table1:"+count+":"+id;
		
		if(document.all){// Se for IE
			while (document.getElementById(firstRadioButtonName) == undefined){
				count += 5;
				firstRadioButtonName = "form1:table1:"+count+":"+id;
			}
			while (document.getElementsByName(firstRadioButtonName)[1] != undefined){
				if(document.getElementsByName(firstRadioButtonName)[1].checked){
					return document.getElementsByName(firstRadioButtonName)[1].value;
				}
				count++;
				firstRadioButtonName = "form1:table1:"+count+":"+id;
			}
		return '';
		
		}else{// Se nï¿½o for IE
			while (document.getElementById(firstRadioButtonName) == undefined){
				count += 5;
				firstRadioButtonName = "form1:table1:"+count+":"+id;
			}
			while (document.getElementsByName(firstRadioButtonName)[0] != undefined){
				if(document.getElementsByName(firstRadioButtonName)[0].checked){
					return document.getElementsByName(firstRadioButtonName)[0].value;
				}
				count++;
				firstRadioButtonName = "form1:table1:"+count+":"+id;
			}
		return '';
		}
	}


	
	
	/**
	 * Seta o conteudo do DIV e o mostra se o conteudo for diferente de vazio.
	 */
	function setDescricao(campo, valor, form){
		if(valor == '' || valor == null){
			document.getElementById('div' + campo).style.display = 'none';
		}else{
			document.getElementById('div' + campo).style.display = 'block';
		}
		document.getElementById(form + ':' + 'edt' + campo).value = valor;
	}
	
	/**
	 * Mostrar descriï¿½ï¿½o de um dado campo de cï¿½digo, caso a descriï¿½ï¿½o
	 * esteja preenchida.
	 */
	function mostrarDescricao(campo, form){
		if(document.getElementById(form + ':' + 'edt' + campo).value != ''){
			document.getElementById('div' + campo).style.display = 'block';
		}
	}
	
	
	function blockEnterSubmit(e){
		var tecla=(window.event)?e.keyCode:e.which;
		if(tecla == 13){
			return false;	
		}
		return true;
	}
	
	/**
	 * Requisiï¿½ï¿½o assincrona para buscar o nome do banco a partir de seu
	 * identificador.
	 */	
	 function buscarNomeBanco(form, fieldId, fieldName){
		var codigoBanco = DWRUtil.getValue(form + ':' + fieldId);
		if(codigoBanco != ''){
			ajaxUtil.buscarNomeBanco(codigoBanco,{
				callback:function(nome){
					setDescricao(fieldName,nome, form);
				}
			});
	 	}
	 	if(codigoBanco == '')
	 		document.getElementById('div' + fieldName ).style.display = 'none';
	 }
	
	/**
	 * Requisiï¿½ï¿½o assincrona para buscar o nome do banco a partir de seu
	 * identificador.
	 */	
	 function buscarNome(form, fieldId, fieldName, entidade){
		var id = DWRUtil.getValue(form + ':' + fieldId);
		if(id != ''){
			ajaxUtil.buscarNome(id, entidade, {
				callback:function(nome){
					setDescricao(fieldName, nome, form);
				}
			});
	 	} else {
	 		document.getElementById('div' + fieldName ).style.display = 'none';
	 	}
	 }
	 
	 
	
	/**
	 * Formatar Valor
	 */ 
	function float2moeda(num) {
		
		x = 0;
		
		if(num<0) {
		num = Math.abs(num);
		x = 1;
		} if(isNaN(num)) num = "0";
		cents = Math.floor((num*100+0.5)%100);
		
		num = Math.floor((num*100+0.5)/100).toString();
		
		if(cents < 10) cents = "0" + cents;
		for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)
		num = num.substring(0,num.length-(4*i+3))+'.'
		+num.substring(num.length-(4*i+3)); ret = num + ',' + cents; if (x == 1) ret = ' - ' + ret;return ret;

	}
	
	/** Valida o campo dia* */
	function validarCampoDia(e){
		var tecla;  
  		tecla = (window.event)?e.keyCode:e.which;
  		if(tecla >=48 && tecla<=57){
  		 	return true;
  		}else{
			if(tecla == 0 || tecla == 8 || tecla == 9 || tecla == 46 || tecla == 39){
				return true;
			}
  		}
  		return false;
	}
	
	/** Valida o campo vigï¿½ncia* */
	function validarCampoVigencia(objeto,e){
		var tecla;  
  		tecla = (window.event)?e.keyCode:e.which;
  		if(tecla >=48 && tecla<=57){
	  		if (objeto.value.length == 2){
				objeto.value = objeto.value+"/";
			}
  		 	return true;
  		}else{
			if(tecla == 0 || tecla == 8 || tecla == 9 || tecla == 46 || tecla == 39){
				return true;
			}
  		}
  		return false;
	}
	
	/**
	 * Original: Ronnie T. Moore Web Site: The JavaScript Source Dynamic 'fix'
	 * by: Nannette Thacker Web Site: http://www.shiningstar.net
	 */
	function limitTextArea(e, field, countFieldId, maxlimit) {		 
		var countField = getSpan(countFieldId);
		if (field.value.length > maxlimit) // if too long...trim it!
			field.value = field.value.substring(0, maxlimit);
			// otherwise, update 'characters left' counter
		else 
			countField.firstChild.nodeValue = maxlimit - field.value.length;
	}
	
	 /**
		 * Retorna um Label com base em um ID.
		 */
	function getSpan(idLabel){
		var fields = document.getElementsByTagName("span");
		for (i = 0; i <= fields.length - 1; i++) {
	    	if(fields[i].id.indexOf(idLabel) != -1){
	    		retorno = fields[i];
	    		break;
	    	}
		}
		return retorno;
	} 
	/* Mascara a taxa de remuneracao */
	function mascaraTaxa(campo,e){
		var tecla=(window.event)?e.keyCode:e.which;
		if(campo.value.length > 0 && tecla!=46 && tecla!=8){
			if (campo.value.length == 2 && campo.value.substring(0,1)!="," && campo.value.substring(1,2)!=","){
				campo.value = campo.value+",";
			}
			campo.value = tiraCaracterMascara(campo.value,",");
		}
	}
	/* Mascara data no formato mm/aaaa */
	function mascaraMesAno(campo,e){
		var tecla=(window.event)?e.keyCode:e.which;
		if(campo.value.length > 0 && tecla!=46 && tecla!=8){
			if (campo.value.length == 2 && campo.value.substring(0,1)!="/" && campo.value.substring(1,2)!="/"){
				campo.value = campo.value+"/";
			}
			campo.value = tiraCaracterMascara(campo.value,"/");
		}
	}

	/* realiza bloqueio de caracteres especificos ao campo */
	function tiraCaracterMascara(texto,caracter){
		resultado = "";
		barra = true;
	 	for(i=0;i<texto.length;i++){
	 		if(characterIsNumber(texto.charAt(i))){
	 			resultado = resultado+texto.charAt(i);
	 		}else if(texto.substring(i,i+1)== caracter && barra && i!=0){
	 			resultado = resultado+caracter;
	 			barra = false;
	 		}
	 		else{
	 			resultado = resultado+"";
	 		}
	 	}
	 	return resultado;
	}
	
	
	function characterIsNumber(character){
		return (character == 0 || character == 1 || character == 2 || character == 3 || character == 4 ||  
	 			character == 5 || character == 6 || character == 7 || character == 8 || character == 9);
	}

	/*
	 * Formatação de campo numérico para moeda retorno 1.000.000,0000 Formato:
	 * 7(inteiros) e 4(decimais) Obs: as casas decimais podem ser definida por
	 * parâmetro possui dependência com mascaraMoeda(campo, casasDecimais,
	 * evento)
	 */
	function FormataMoeda(campo, casasDecimais, e) {
		var tecla;
		if(window.event) {
			tecla = e.keyCode;
		}else if(e.which) {
			tecla = e.which; 
		}else{
			return true;
		}
		
		if (tecla != 9 ){
			if((campo.value.length ) <= campo.getAttributeNode("maxlength").value){
				mascaraMoeda(campo, casasDecimais,tecla);		
			}else{
				return false;
			}
		}
		return soDecimal(e);
	}	

	function mascaraMoeda(campo, casasDecimais, e){

		var vr = new String(campo.value);
		// Remove os 0 antes da virgula
		vr = vr.replace(/\D/g,"");
		
		// Remove zeros inutilizados
		vr = removeZerosEsquerda(vr);		
		
		var tam = vr.length ;
		
		// Trata o primeiro bloco, quando as casas decimais forem menores que o
		// tamanho mínimo exigido
		if(tam <= casasDecimais){
			while(tam < casasDecimais){
				vr = '0'+ vr;
				tam++;
			}
			return campo.value = 0 + ',' + vr;
		}
		if ( (tam > casasDecimais) && (tam <= casasDecimais+3) ){
	 		return campo.value = vr.substring( 0, tam - casasDecimais ) + ',' + vr.substring( tam - casasDecimais, tam ) ; }
		
		if ( tam > (casasDecimais+3) && tam <= (casasDecimais+6)){
			return campo.value = vr.substring(0, tam-casasDecimais-3) + '.' + vr.substring(tam-casasDecimais-3, tam-casasDecimais) + ',' +  vr.substring(tam-casasDecimais, tam);			
		}
		if (tam >= (casasDecimais+6) && tam <= (casasDecimais+9)){
			return campo.value =vr.substring(0, tam-casasDecimais-6) + '.'+ vr.substring(tam-casasDecimais-6, tam-casasDecimais-3) + '.' + vr.substring(tam-casasDecimais-3, tam-casasDecimais) + ',' +  vr.substring(tam-casasDecimais, tam);	
		}
		if (tam >= (casasDecimais+9) && tam <= (casasDecimais+12)){
			return campo.value =vr.substring(0, tam-casasDecimais-9) + '.'+ vr.substring(tam-casasDecimais-9, tam-casasDecimais-6) + '.'+ vr.substring(tam-casasDecimais-6, tam-casasDecimais-3) + '.' + vr.substring(tam-casasDecimais-3, tam-casasDecimais) + ',' +  vr.substring(tam-casasDecimais, tam);	
		}
		if (tam >= (casasDecimais+12) && tam <= (casasDecimais+15)){
			return campo.value =vr.substring(0, tam-casasDecimais-12) + '.'+ vr.substring(tam-casasDecimais-12, tam-casasDecimais-9) + '.'+ vr.substring(tam-casasDecimais-9, tam-casasDecimais-6) + '.'+ vr.substring(tam-casasDecimais-6, tam-casasDecimais-3) + '.' + vr.substring(tam-casasDecimais-3, tam-casasDecimais) + ',' +  vr.substring(tam-casasDecimais, tam);	
		}
		if (tam >= (casasDecimais+15) && tam <= (casasDecimais+18)){
			return campo.value =vr.substring(0, tam-casasDecimais-15) + '.'+ vr.substring(tam-casasDecimais-15, tam-casasDecimais-12) + '.'+ vr.substring(tam-casasDecimais-12, tam-casasDecimais-9) + '.'+ vr.substring(tam-casasDecimais-9, tam-casasDecimais-6) + '.'+ vr.substring(tam-casasDecimais-6, tam-casasDecimais-3) + '.' + vr.substring(tam-casasDecimais-3, tam-casasDecimais) + ',' +  vr.substring(tam-casasDecimais, tam);	
		}
		return false;
	}
	
	
	function soDecimal(e) {
		var key;
		var keychar;
		var reg;
		
		if(window.event) {
			key = e.keyCode; 
		}else if(e.which) {
			key = e.which; 
		}else{
			return true;
		}

		if (key==8 || key==13 || key==44)
			return true;
	    
	    keychar = String.fromCharCode(key);
		reg = /\d/;
		return reg.test(keychar);	
	}
	
	/*
	 * Funï¿½ï¿½o que remove zeros ï¿½ esquerda Ex: 0000254 result:254
	 */
	function removeZerosEsquerda(valor){
		   var i;
		   for(i=0;i<valor.length;i++)
		      if(valor.charAt(i)!='0')
		         return valor.substring(i);
		   return valor;
	}
	
	// limpa o componente de consulta de agencia que utiliza o popup
	function limparFiltroAgencia(thisObj, thisEvent) {
		document.getElementById('formId:txtNomeAgencia').value = "";
		document.getElementById('formId:hiddenAgencia').value = "";
		document.getElementById('formId:hiddenNomeAgencia').value = "";
	}
	
	
	// limpa o componente de consulta de programa que utiliza o popup
	function limparFiltroPrograma() {
		if(document.getElementById('formId:txtNomePrograma') != null){
			document.getElementById('formId:txtNomePrograma').value = "";
		}
		if(document.getElementById('formId:hiddenCodigoPrograma') != null){
			document.getElementById('formId:hiddenCodigoPrograma').value = "";
		}
		if(document.getElementById('formId:hiddenNomePrograma') != null){
			document.getElementById('formId:hiddenNomePrograma').value = "";
		}
	}
	
	// limpa o componente de consulta de programa que utiliza o popup
	function limparFiltroEventoSede(thisObj, thisEvent) {
		document.getElementById('formId:txtNomeEventoSede').value = "";
		document.getElementById('formId:hiddenCodigoEvento').value = "";
		document.getElementById('formId:hiddenNomeEvento').value = "";
	}
	// limpa o componente de consulta de eventoSEDE que utiliza o popup
	function limparFiltroEventoSEDE(thisObj, thisEvent) {
		document.getElementById('formId:txtEventoSEDE2').value = "";
		document.getElementById('formId:hiddenEventoSEDE').value = "";
		document.getElementById('formId:hiddenNomeEventoSEDE').value = "";
	}
	
	
	
	// funcao responsavel pela acao de expandir e minimizar os filtros de busca
	var ocultaFiltro = 0;
	function showFiltro(id) {
		if (ocultaFiltro == 0){
			document.getElementById('formId:' + id).style.display = "none";
			document.forms['formId'].bntShow.src = "img/maximizar.gif";
			document.forms['formId'].bntShow.alt = "Exibir Filtro";
			document.forms['formId']['formId:ocultar'].value = "true";
			ocultaFiltro = 1;
		} else {
			document.getElementById('formId:' + id).style.display = "block";
			document.forms['formId'].bntShow.src = "img/minimizar.gif";
			document.forms['formId'].bntShow.alt = "Ocultar Filtro";
			document.forms['formId']['formId:ocultar'].value = "false";
			ocultaFiltro = 0;
		}
	}
	
	// Nova funcao responsavel por expandir e minimizar os filtros de busca
	// Ha uma funcao generica para qualquer bloco de dados
	function showFieldset(id,elemento) {
		if(document.getElementById(id).style.display == "block"){
				document.getElementById(id).style.display = "none";
				elemento.src = "img/maximizar.gif";
				elemento.alt = "Exibir Seção";
		} else {
			document.getElementById(id).style.display = "block";
			elemento.src = "img/minimizar.gif";
			elemento.alt = "Ocultar Seção";
		}
	}
	// Esta funÃ§Ã£o tem o objetivo de permitir uma quantidade limite
	// de caracteres de um determinado campo.
	function excedeuLimite(elemento,tamanho_limite){
		var tamanho_atual = elemento.value.length ;
		if(tamanho_atual <= tamanho_limite){
			return true;
		}else{
			elemento.value =  elemento.value.substr(0,tamanho_limite);
		}
	}
	// Esta funcao tem o objetivo atualizar o campo de caracteres restantes para
	// o campo.
	function ajustarContador(elementoTexto,nomeCampoDestino,limite,mensagemErro){
		var caracteresRestantes = limite - elementoTexto.value.length;
		var campo = document.getElementById(nomeCampoDestino);
		var permiteInserir = excedeuLimite(elementoTexto,limite);

		if(permiteInserir == true){
			campo.className = '';
			campo.innerHTML = 'Caracteres restantes:'+ caracteresRestantes +' de '+ limite +'.';
			return true;
		}else{
			campo.className = 'mensagemErro';
			campo.innerHTML = mensagemErro;
		}
	}
	
	// Funcao utilizada para atualizar o campo
	// caso exista alguma modificacao nos valores informados
	function houveAlteracao(id,situacao){
		campo = document.getElementById(id);
		campo.value = situacao;
	}
	
	function exigeConfirmacao(id){
		elemento = document.getElementById(id);
		if(elemento.value == "true"){
			resposta = confirm('H\u00e1 altera\u00e7\u00f5es n\u00e3o salvas. Deseja prosseguir e descart\u00e1-las?');
			if(resposta){
				elemento.value = false;
				history.back();
			}
		}else{
			history.back();
		}
	}
	// Funcao utilizada para somar valores de um datatable
	// e salvar no campo destino (totalizador ).
	//
	function somaValores(fieldset,indiceTabela,linhaInicial,colunaSomadora,casasDecimais,digitoIdentificador){
		var elementoDestino = null;
		var destino = null; 
		var divPai = null;
		var filhos = null;
		var linhas = 0;
		var total = 0;
		
		if(digitoIdentificador != null && digitoIdentificador != ""){
			divPai = document.getElementById(fieldset+":"+ digitoIdentificador);
		}else{
			divPai = document.getElementById(fieldset);
		}
		
		// Recupera a tabela de atualizacoes
		destino = divPai.getElementsByTagName("table")[0];
		
		elementoDestino = destino.rows[1].cells[1].getElementsByTagName("input")[0];
		
		// Recupare a tabela dos valores
		filhos = divPai.getElementsByTagName("table")[indiceTabela];
		
		linhas = filhos.rows.length;
		for(i=linhaInicial;i < linhas;i++){
			valorCelula =  filhos.rows[i].cells[1].getElementsByTagName("input")[colunaSomadora].value;
			if(valorCelula != isNaN ){
				valorCelula =  valorCelula.replace(',','').replace(',','');
				valorCelula = valorCelula.replace('.','').replace('.','').replace('.','');
				total+=parseFloat(valorCelula);
			}
		}
		elementoDestino.value = total;
		mascaraMoeda(elementoDestino, casasDecimais);
	}
	
	/*
	 * Funcao especifica para totalizar os dados de tabelas de um determinado
	 * dominio de tabelas prefixo:indice:propriedadeTotalizadora;
	 */
	function totalizadorDePagamentos(nomeCampoTotalizador,prefixo,propriedadeTotalizadora,casasDecimais){
		// Totalizador do valor contabilizado
		var indice = 0;
		var totalizador = 0;
		var campoTotalizador = document.getElementById(nomeCampoTotalizador);
		
		// percorrer todos os nós do contexto
		while(document.getElementById(prefixo+":"+indice+":"+propriedadeTotalizadora)!= null){
			valorTabela = document.getElementById(prefixo+":"+indice+":"+propriedadeTotalizadora).value;
			valorTabela =  valorTabela.replace(',','').replace(',','');
			valorTabela = valorTabela.replace('.','').replace('.','').replace('.','');
			totalizador+= parseFloat(valorTabela);
			indice++;
		}
		// Atualiza valor no total
		campoTotalizador.value = totalizador;
		mascaraMoeda(campoTotalizador,2,null);
	}
	
	/*
	 * Remove valor de um determinado campo através do id.
	 */
	function limparValorCampo(idElemento){
		var elemento = document.getElementById(idElemento);
		if(elemento != null){
			elemento.innerHTML = "";
		}
	}
	
	/*
	 * Ajusta o foco para o campo desejado
	 */
	function setarFoco(nomeElemento){
		var elemento = document.getElementById(nomeElemento);
		if(elemento != null){
			elemento.focus();
		}
	}
	
	/*
	 * Função utilizada para ocultar um determinado objeto atraves do nome
	 */
	function ocultarMensagem(nomeObjeto){
		var div = document.getElementById(nomeObjeto);
		if(div != null){
			div.style.display = 'none';
		}
	}