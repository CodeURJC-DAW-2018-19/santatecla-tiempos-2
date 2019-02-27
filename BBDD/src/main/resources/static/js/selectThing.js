function select(id) 
{
	var bodycontent, footercontent;
	
	bodycontent = document.getElementsByClassName("form-row selectID");
	footercontent = document.getElementsByClassName("modal-footer selectID");
	
	for(var i = 0; i < bodycontent.length; i++){
		var bContent = bodycontent[i].getAttribute("id");
		if(bContent==id){
			bodycontent[i].className = bodycontent[i].className.replace(" hidden", "");
		}else{
			var list = bodycontent[i].classList;
			if(!list.contains("hidden")){
				bodycontent[i].className += " hidden";
			}
		}
		var fContent = footercontent[i].getAttribute("id");
		if(fContent==id){
			footercontent[i].className = footercontent[i].className.replace(" hidden", "");
		}else{
			var list = footercontent[i].classList;
			if(!list.contains("hidden")){
				footercontent[i].className += " hidden";
			}
		}
	}

}
