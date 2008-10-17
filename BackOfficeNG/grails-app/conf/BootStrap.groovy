class BootStrap {

     def init = { servletContext ->
        servletContext.setAttribute("newDataBinder", GlobalPropertyEditorConfig.&newDataBinder)
     }
     def destroy = {
     }
} 
