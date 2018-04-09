FormItem  = function(label,id){
	this.label = label;
	this.id = id;
	
	
}
EGOVUtil = function(){
	this.isNull = function(FormItems){
		for(var i=0;i<FormItems.length;i++){
			var label = FormItems[i].label;
			var id = FormItems[i].id;
			var elet = document.getElementById(id);
			if(elet.value==""){
				alert(label+"为空，请重新输入");
				elet.focus();
				return false;
			}
			
		}
		return true;
		
	}
	this.isSame = function(FormItem1,FormItem2){
		 var id1 = FormItem1.id;
		 var label1 = FormItem2.label;
		 var id2 = FormItem2.id;
		 var label2= FormItem2.label;
		 var elet1 = document.getElementById(id1);
		 var elet2 = document.getElementById(id2);
		 if(elet1.value!=elet2.value){
			 alert(label1+"和"+label2+"不一致，请重新填写");
			 elet2.value = "";
			 elet1.focus();
			 return false;
		 }
		return true;
	}
	
	
	
	
	
}