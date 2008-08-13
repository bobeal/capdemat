function DatVal(Q, J, C) { var Mon, x, Rex, B, Y, S, ND=0
    Q = trim(Q);
    if (J==0) { Rex = /(\d+)(\d{2})(\d{2})$/     // D5+ as Y+MMDD
      Q = Q.search(Rex)==-1 ? '' : Q.replace(Rex, '$1 $2 $3') // split
     } // optional paragraph

//    Rex = new RegExp(Suf[Lx], 'i') // Remove suffix, see * below
//    Q = Q.replace(Rex, ' ')  // optional paragraph

    Rex = /([^A-Z]+)([IVX]{1,4})(.*)/i // Seek Roman (month) : viii IX
    if (Rex.test(Q)) {
      Mon = Q.replace(Rex, '$2').toUpperCase() // 1-4 Chars of month
      x =
       ' I    II   III  IV   V    VI   VII  VIII IX   X    XI   XII '.
        indexOf(' '+Mon)
      Q = Q.replace(Rex, '$1 '+(1+x/5)+' $3') // make numeric
     } // optional paragraph

    Rex = /([^A-Z]*)([A-Z]{1,4})(.*)/i
    // Seek month letters : Au / Aug. Or {3}.
    if (Rex.test(Q)) {
      Mon = Q.replace(Rex, '$2').toUpperCase() // 1-4 Letters of month
      // x = Months[Lx].indexOf(' '+Mon) // or next for English only, *
//      x = ' JAN FEB MAR APR MAY JUN JUL AUG SEP OCT NOV DEC'.indexOf(' '+Mon)
      x = ' JANV FEVR MARS AVRI MAI  JUIN JUIL AOUT SEPT OCTO NOVE DECE'.indexOf(' '+Mon)
      Q = Q.replace(Rex, '$1 '+(1+x/5)+' $3') // to numeric
      } // optional paragraph

    Rex = /^(\d+)\D+(\d+)\D+(\d+)$/ // three digit fields
    // if (J==1) Q = Q                       // ISO
    if (J==2) Q = Q.replace(Rex, '$3 $2 $1') // EU
    if (J==3) Q = Q.replace(Rex, '$3 $1 $2') // NA
    B = Rex.test(Q) // Split into $1 $2 $3
    if (B) with (RegExp) { Y = +$1
      if (Y<100) Y += (Y<C?2000:1900)      // optional century line
    S = $3 +'/' + $2 + '/' + Y
      with (ND = new Date(Y, $2-1, $3))
        B = ((getMonth()==$2-1) && (getDate()==$3))  } // YMD valid ?
    // For true years 00..99, enter as >2 digits, check $1.length;
    // then increase year by 100 and decrease month by 1200.
    return [B, ND, S] // [Valid, DateObject, String]
    // To ban leading zeros in M, D, and Y,
    // alter all \\d+ in last Rex to [1-9]\\d?  untested.
    /* end DatVal */ }
    
function HideBlock(block) {
  document.getElementById(block).style.display = 'none';
}
