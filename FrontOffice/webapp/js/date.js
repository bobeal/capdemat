function isCheckedDate(day, month, year) {
	        if (month < 1 || month > 12) {
            return false;
          }
          if (day < 1 || day > 31) {
            return false;
          }
          if ((month == 4 || month == 6 || month == 9 || month == 11) &&
              (day == 31)) {
            return false;
          }
          if (month == 2) {
            var leap = (year % 4 == 0 &&
                        (year % 100 != 0 || year % 400 == 0));
            if (day>29 || (day == 29 && !leap)) {
              return false;
            }
          }
          return true;
      }
function checkColourableBirthYear(year) {           
   var isOk = false;
   
   if ((year>1850) && (year<2020)){
     isOk = true;
   } 
   return isOk;                    
}            
function checkDate(form){

    var birthDay = form.birthDay.value;
    var birthMonth = form.birthMonth.value;
    var birthYear = form.birthYear.value;
   
    if ( ("" ==  birthDay) &&
         ("" ==  birthMonth) && 
         ("" ==  birthYear)) {
      return true;
    }
   
    if ( ("" !=  birthDay) &&
         ("" !=  birthMonth) && 
         ("" !=  birthYear)) {
      if(isCheckedDate(form.birthDay.value, form.birthMonth.value, form.birthYear.value) ) {
        if (checkColourableBirthYear(form.birthYear.value)) {
          return true;
        } else {
          return false;
        }  
          
      }else{
        return false;
      }
    }
    return false;
}
            