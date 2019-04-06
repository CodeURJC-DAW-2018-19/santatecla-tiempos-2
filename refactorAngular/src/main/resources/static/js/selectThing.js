function select(id) 
{
	var bodycontent, footercontent;
	
	bodycontent = document.getElementsByClassName("modal-body selectID");
	footercontent = document.getElementsByClassName("modal-footer selectID");
	
	for(var i = 0; i < bodycontent.length; i++){
		var bContent = bodycontent[i].getAttribute("id");
		if(bContent==id){
			bodycontent[i].style.display = "block";
		}else{
			bodycontent[i].style.display = "none";
		}
		var fContent = footercontent[i].getAttribute("id");
		if(fContent==id){
			footercontent[i].style.display = "block";
		}else{
			footercontent[i].style.display = "none";
		}
	}
}
