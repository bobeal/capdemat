<html>
    <head>
        <title>Google Chart API plugin</title>
		<meta name="layout" content="main" />
    </head>
    <body>
    <%
    	def labels = ['First','Second','Third']
    	def colors = ['FF0000','00ff00','0000ff']
    	def values = [35,45,10]
    	def values2 = [[35,45,10],[3,987,2]]
    	def values3 = [97,12,454,12,5,32,78,4,99,89,98,77,7,77]
    	def values4 = [[97,12,454,12,5,32,78,4,99,89,98,77,7,77],[1,6,42,15,78,94,26,45,12,10,21,22,33,33]]
    %>
	<h2>Simple Data Examples</h2>
	<g:lineChart title='Sample Line Chart' titleAttrs="${['440000',30]}" colors="${colors}" 
	 	axes="x,y" gridLines="10,10,1,0" lineStyles="${[[3,6,3]]}" legend="${labels}" axesLabels="${[0:['Jan','Feb','Mar'],1:[0,10,30,50]]}" fill="${'bg,s,efefef'}" dataType='simple' data='${values}' />

	<g:barChart title='Sample Bar Chart' size="${[200,200]}" colors="${colors}" type="bvs"
		labels="${labels}" axes="x,y" axesLabels="${[0:['Jan','Feb','Mar'],1:[0,10,30,50]]}" fill="${'bg,s,efefef'}" dataType='simple' data='${values}' />
	<g:pieChart title='Sample Pie Chart' colors="${colors}" 
		labels="${labels}" fill="${'bg,s,efefef'}" dataType='simple' data='${values}' />

	<g:vennDiagram title='Sample Venn Diagram' colors="${colors}" 
		labels="${labels}" fill="${'bg,s,efefef'}" dataType='simple' data='${values}' />
	<g:scatterPlot title='Sample ScatterPlot' colors="${colors}" 
		labels="${labels}" fill="${'bg,s,efefef'}" dataType='simple' data='${values2}' />

	<h2>Text Data Examples</h2>
	<g:lineChart title='Sample Line Chart' colors="${colors}" 
		axes="x,y" shapeRangeFill="${[['c','FF0000',0,1.0,20.0],['a','990066',0,3.0,9.0],['R','220066',0,0.0,0.5]]}" axesLabels="${[0:['Jan','Feb','Mar','Apr','May','Jun']]}" fill="${'bg,s,efefef'}" dataType='text' data='${values3}' />

	<g:barChart title='Sample Bar Chart' size="${[400,200]}" colors="${colors}" type="bvs"
		labels="${labels}" axes="x,y" axesLabels="${[0:['Jan','Feb','Mar','Apr','May','Jun','Jul']]}" fill="${'bg,s,efefef'}" dataType='text' data='${values3}' />
	<g:pieChart title='Sample Pie Chart' colors="${colors}" 
		labels="${labels}" fill="${'bg,s,efefef'}" dataType='text' data='${values3}' />

	<g:vennDiagram title='Sample Venn Diagram' colors="${colors}" 
		labels="${labels}" fill="${'bg,s,efefef'}" dataType='text' data='${values3}' />
	<g:scatterPlot title='Sample ScatterPlot' colors="${colors}" 
		labels="${labels}" fill="${'bg,s,efefef'}" dataType='text' data='${values4}' />

	<h2>Extended Data Examples</h2>
	<g:lineChart title='Sample Line Chart' colors="${colors}" 
		axes="x,y" axesLabels="${[0:['Jan','Feb','Mar','Apr','May','Jun']]}" fill="${'bg,s,efefef'}" dataType='extended' data='${values3}' />

	<g:barChart title='Sample Bar Chart' size="${[400,200]}" colors="${colors}" type="bvs"
		labels="${labels}" axes="x,y" axesLabels="${[0:['Jan','Feb','Mar','Apr','May','Jun','Jul']]}" fill="${'bg,s,efefef'}" dataType='extended' data='${values3}' />
	<g:pieChart title='Sample Pie Chart' colors="${colors}" 
		labels="${labels}" fill="${'bg,s,efefef'}" dataType='extended' data='${values3}' />

	<g:vennDiagram title='Sample Venn Diagram' colors="${colors}" 
		labels="${labels}" fill="${'bg,s,efefef'}" dataType='extended' data='${values3}' />
	<g:scatterPlot title='Sample ScatterPlot' colors="${colors}" 
		labels="${labels}" fill="${'bg,s,efefef'}" dataType='extended' data='${values4}' />
    </body>
</html>
