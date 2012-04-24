<g:layoutFO
   head="${'<title>' + g.layoutTitle(default:'Front Office CapDémat') + '</title>' + g.render(template:'/shared/fo_resources') + g.layoutHead()}"
   header="${g.render(template:'/shared/fo_header')}"
   login="${g.render(template:'/shared/fo_login')}"
   nav="${g.render(template:'/shared/fo_menu')}"
   contents="${g.render(template:'/shared/fo_contents')}"
   footer="${g.render(template:'/shared/fo_footer')}"
/>
