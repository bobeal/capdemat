import groovy.sql.Sql

def sql = Sql.newInstance("jdbc:postgresql://localhost:5432/mpg_saintgermain", "capdemat",
                      "capdematpass", "org.postgresql.Driver")
                      
// now let's populate the table
def cfa = sql.dataSet("capwebct_family_account")
def ci = sql.dataSet("capwebct_individual")
def cas = sql.dataSet("capwebct_association_summary")
def j = 1
for (i in 1..100000) {
    cfa.add( id:i, capwebct_family_account_id:i, address:i + ", rue des petits pois carottes" )
    cas.add(capwebct_family_account_id:i, external_application_id:2, state:"not_associated")
    ci.add(id:j, capwebct_individual_id:j, first_name:"Ernesto", last_name:"Guevara", 
            child:false, responsible:true, capwebct_family_account_fk_id: i)
    j++
    ci.add(id:j, capwebct_individual_id:j, first_name:"Louise", last_name:"Michel", 
            child:false, responsible:false, capwebct_family_account_fk_id: i)
    j++
}
