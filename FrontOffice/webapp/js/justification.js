//Cartevaloise 
//
//Copyright (C) 2005 Conseil Général du Val d'Oise. All Rights
//Reserved.
//
//This program is free software; you can redistribute it and/or
//modify it under the terms of the GNU General Public License as
//published by the Free Software Foundation; either version 2 of the
//License, or (at your option) any later version.
// 
//This program is distributed in the hope that it will be useful, but
//WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//General Public License for more details.
// 
//You should have received a copy of the GNU General Public License
//along with this program; if not, write to the Free Software
//Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
//02111-1307, USA.
//
// Author        : C. Foiret (CG95)
// Creation Date : 16/02/2005
// Object : JS functions for Justification Form (Citizen, School, Perischool, Canteen)

// ---- General Function of Validation Form ----
function validateAndSubmit(form) {
  if (true == validateFileForm(form)){
    if (validateMyMask(form)) {
      form.submit();
    }
  }  
}

