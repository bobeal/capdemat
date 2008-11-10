<html>
<body>

<div>
<h1>Using debug tags</h1>
<p>
To show debug information in your views, use the &lt;debug:info/&gt; tag. This will display all information collected
for the current request. The optional "category" attribute lets you display a single category. Predefined
categories include: params, model, requestAttributes, controller, session, headers, stats, system.
</p>
<p>
You can log name/value pairs from your own code by injecting "debugService" and calling "traceVar(request, category, name, value)" on it.
</p>
</div>

<g:link action="controlPanel">View Control Panel</g:link>

<div>
	<debug:info/>
</div>


</body>
