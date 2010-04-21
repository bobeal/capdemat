

class CalendarTagLib {
    def styles = [:]
    def calendar =  Calendar.instance
    
    def activityCalendar = {attrs,body ->
        def year = attrs.year ? attrs.year : Calendar.instance.get(Calendar.YEAR)
        def month = attrs.month ? Integer.valueOf(attrs.month) - 1 : (Calendar.instance.get(Calendar.MONTH))
        def data = attrs.data, i = 0
        
        if(data instanceof Map) {
            for(String key: data.keySet()) {
                styles[key] = 'legend-label-'+ (i++).toString()
            }
        }
        
        calendar.setFirstDayOfWeek(Calendar.MONDAY)
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
        for(Integer wom : cal1.keySet()) {
            if(cal2[wom]) {
                def tr = ''
                for(Integer row : cal1[wom]) {
                    def index = cal1[wom].indexOf(row)
                    
                    if(cal2[wom][index]) tr += this.buildCell(cal2[wom][index], data)
                    else if(wom == 1) tr = "\t\t<td></td>\n" + tr
                    else tr += "\t\t<td></td>\n"
                }
                table += "\t<tr>\n$tr\n\t</tr>\n"
            }
        }
        table = """
<table class="activity-calendar">
  <thead>
\t<tr>
\t\t<th>${message(code:'header.monday')}</th>
\t\t<th>${message(code:'header.tuesday')}</th>
\t\t<th>${message(code:'header.wednesday')}</th>
\t\t<th>${message(code:'header.thursday')}</th>
\t\t<th>${message(code:'header.friday')}</th>
\t\t<th>${message(code:'header.saturday')}</th>
\t\t<th>${message(code:'header.sunday')}</th>
\t</tr>
  </thead>
  <tbody>
$table
  </tbody>
</table>
"""     
        out << table
    }
    
    protected String buildCell(Integer dom, Map<String,List<Date>> data) {
        def c = new GregorianCalendar();
        def result =  '\t\t<td><span class="value">' + dom + '</span><div class="container">'
        calendar.set(Calendar.DAY_OF_MONTH, dom)

        data.each {
        	def activityLabel = it.key
            for (Date date : data[activityLabel]) {
        	    c.setTime(date)
                if(c.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH) 
                    && c.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) 
                    && c.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)) {
                    result += '<span class="indicator '+styles[activityLabel]+'">&nbsp;</span>'
                    break;
                }
        	}
        }
        
        return result + "</div></td>\n";
    }
}