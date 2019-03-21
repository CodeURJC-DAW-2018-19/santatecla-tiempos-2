function processCategories()
{
	var categories = document.getElementsByName("categList");
	var selectedCategories = [];
	for(var i = 0; i < categories.length; i++){
		if(categories[i].checked){
			selectedCategories.push(categories[i].value)
		}
	}
	
	var hiddenSelected = document.getElementById("selectedCat");
	hiddenSelected.value = selectedCategories.join(",");
	
}

function processCategoriesUpdate(){
	var categories = document.getElementsByName("categListUpdate");
	var selectedCategories = [];
	for(var i = 0; i < categories.length; i++){
		if(categories[i].checked){
			selectedCategories.push(categories[i].value)
		}
	}
	
	var hiddenSelected = document.getElementById("selectedCatUpdate");
	hiddenSelected.value = selectedCategories.join(",");
	
}
