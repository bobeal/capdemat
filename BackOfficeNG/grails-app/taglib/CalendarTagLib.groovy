

class CalendarTagLib {
    def styles = [:]
    def calendar =  Calendar.instance //new GregorianCalendar()
    
    def activityCalendar = {attrs,body ->
        def year = attrs.year ? attrs.year : Calendar.instance.get(Calendar.YEAR)
        def month = attrs.month ? Integer.valueOf(attrs.month) - 1 : (Calendar.instance.get(Calendar.MONTH))
        def data = attrs.data, i = 0
        
        if(data instanceof Map) {
            for(String key: data.keySet()) {
                styles[key] = 'marked-item-'+ (i++).toString()
            }
        }
        
        calendar.set(Calendar.DATE, 1)
        calendar.set(Calendar.ERA, GregorianCalendar.AD)
        calendar.set(Calendar.YEAR, Integer.valueOf(year))
        calendar.set(Calendar.MONTH, Integer.valueOf(month))
        
        def cal1 = [:], cal2 = [:]
        for(Integer num : (1..6)) cal1[num] = [1,2,3,4,5,6,7]
        
        for(Integer day : (1 .. calendar.getActualMaximum(Calendar.DAY_OF_MONTH))) {
            calendar.set(Calendar.DATE, day)
            def wom = calendar.get(Calendar.WEEK_OF_MONTH)
            def dom = calendar.get(Calendar.DAY_OF_MONTH)
            
            if(!cal2[wom]) cal2[wom] = []
            cal2[wom].add(dom)
        }
        
        calendar.set(Calendar.DATE, 1)
        
        def table = ''
        for(Integer col : cal1.keySet()) {
            if(cal2[col]) {
                def tr = ''
                for(Integer row : cal1[col]) {
                    def index = cal1[col].indexOf(row)
                    
                    if(cal2[col][index]) tr += this.buildCell(cal2[col][index].toString(),data)
                    else if(col == 1 && !cal2[col][index]) tr = "\t\t<td></td>\n" + tr
                    else tr += "\t\t<td></td>\n"
                    
                }
                table += "\t<tr>\n$tr\n\t</tr>\n"
            }
        }
        table = """
<table class="activity-calendar">
  <thead>
\t<tr>
\t\t<th>${message(code:'header.sunday')}</th>
\t\t<th>${message(code:'header.monday')}</th>
\t\t<th>${message(code:'header.tuesday')}</th>
\t\t<th>${message(code:'header.wednesday')}</th>
\t\t<th>${message(code:'header.thursday')}</th>
\t\t<th>${message(code:'header.friday')}</th>
\t\t<th>${message(code:'header.saturday')}</th>
\t</tr>
  </thead>
  <tbody>
$table
  </tbody>
</table>
"""     
        out << table
    }
    
    protected String buildCell(String value, Map<String,Date> data) {
        def c = new GregorianCalendar();
        def result =  '\t\t<td><span class="value">' + value + '</span>'
        calendar.set(Calendar.DAY_OF_MONTH,Integer.valueOf(value))
        
        for(String key: data.keySet()) {
            for(Date date: data[key]) {
                c.setTime(date);
                if(c.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH) 
                    && c.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) 
                    && c.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)) {
                    result += '<span class="indicator '+styles[key]+'">&nbsp;</span>'
                    break;
                }
            }
        }
        
        return result + "</td>\n";
    }
    
}