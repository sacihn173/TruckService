# TruckService

APIs : 
1. Post "/load"
    
    Payload:
    
            {
    
                "loadingPoint": "",
      
                "unloadingPoint": "",
      
                "productType": "",
      
                "truckType": "",
      
                "noOfTrucks": "",
      
                "weight": "",
      
                optional:"comment": "",
      
                “shipperId” : “shipper:<UUID>”,
      
                “Date” : “dd-mm-yyyy”
        
            }


    Response:loads details added successfully 


2. GET “/load”

      Query params - (shipperId)

      Response: list of loads with this shipperId

3. GET “load/{loadId}”

4. PUT “load/{loadId}”

      {
      
        "loadingPoint": "",
        
        "unloadingPoint": "",
        
        "productType": "",
        
        "truckType": "",
        
        "noOfTrucks": "",
        
        "weight": "",
        
        "comment": "",
        
        “Date” : “dd-mm-yyyy”	
        
      }


5.DELETE “load/{loadId}”
