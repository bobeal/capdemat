import groovy.sql.Sql

def sql = Sql.newInstance("jdbc:postgresql://localhost:5432/mpg_saintgermain", "capdemat",
                      "capdematpass", "org.postgresql.Driver")
                      
// now let's populate the table
def payment = sql.dataSet("payment")
def now = new Date()
def j = 1
for (i in 1..10000) {
    payment.add( id:i, payment_type:"CB", payment_amount:i*100, 
		 payment_ack:"PaymentAck-"+i, cvq_ack:"CvqAck-"+i, cfa_id:i,
		 broker:"Regie CCAS")
}
