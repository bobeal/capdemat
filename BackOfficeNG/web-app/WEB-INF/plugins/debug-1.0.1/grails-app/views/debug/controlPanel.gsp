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

<g:link action="info">View All Debug Info</g:link>

<div>
	<h2>Application</h2>
	Grails version: ${grailsApplication.metadata['app.grails.version']}<br/>
	Grails Environment: ${env} <br/>
	Application version: ${grailsApplication.metadata['app.version']}<br/>
	
	<table><tr><td valign="top">
	Artefacts:<br/>
	<ul>
		<g:each in="${grailsApplication.artefactHandlers}" var="art">
			<li>${art.type}: ${grailsApplication[art.type+'Classes'].size()} - 
					<g:each in="${grailsApplication.getArtefacts(art.type)}" var="theClass">
				    ${theClass.logicalPropertyName}
					</g:each></li>
		</g:each>
	</ul>
	</td>
	<td valign="top">
	Plugins:<br/>
	<ul>
		<g:each in="${plugins}" var="plugin">
			<li>${plugin.name} ${plugin.version}</li>
		</g:each>
	</ul>
	</td></tr></table>
</div>

<div>
	<h2>Tools</h2>
	<g:link action="flushSession">Flush your session</g:link><br/>
	<br/>
    NOT YET IMPLEMENTED:<br/>
	<g:link action="codeEditor">Edit code</g:link><br/>
	<g:link action="console">Console</g:link> (using ajax)<br/> 
	<g:link action="toggleSQLDebug">Toggle SQL debug output</g:link><br/>
	<g:link action="targets">Run a grails command</g:link> (create-controller etc)<br/>
</div>

<div>
	<h2>Support</h2>
	<a href="http://jira.codehaus.org/secure/CreateIssue!default.jspa">Report a Grails issue</a><br/>
	<form action="http://jira.codehaus.org/secure/IssueNavigator.jspa" method="GET">Find a Grails issue <input name="query"/> 
		<input type="hidden" name="reset" value="true"/>
		<input type="hidden" name="description" value="true"/>
		<input type="hidden" name="summary" value="true"/>
		<input type="hidden" name="body" value="true"/>
		<input type="hidden" name="pid" value="11063"/>
		<input type="submit" value="Search"/></form><br/>
</div>


</body>
