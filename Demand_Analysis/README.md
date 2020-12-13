This part of the program is used to streghten the already existing model of CNN and hence better predict the demands of various clothing styles in the market. In this part, we are training a LSTM for predicting the demand of a particuar clothing style based on time-series retail data of past few days/weeks.

## The CSV File ##
The CSV file contains the time-series data of a retail store of past 10 days. It shows the sales of Shirts, Skirts, Jackets and Denims. The fields that are included in the CSV are ['Cloth type', 'Average Selling Price','Average Customer footfall', 'Total pcs manufactured', 'Pcs. Sold', 'Demand']
The demand has been defined as a percentage (=(Pcs. Sold/Total pcs manufactured) * 100)

## The Task ##
The task is to predict the demand of various clothing styles based on their Selling price and Customer footfall.
The demands for the various clothing styles will then be directly transferred to the app where certain statistics will be shown to retailers. 

## Preprocessing required for LSTM ##
Certain preprocessing is required to be applied before we can train the LSTM network. Below is a snapshot of data after preprocessing (for shirt)

['Selling Price(t-1)', 'Footfall(t-1)' , 'Manufactured pcs(t-1)', 'Pcs.Sold(t-1)', 'Demand(t-1)']

(https://github.com/AshutoshDas07/ABN_HackOffv3.0/blob/master/Demand_Analysis/Preprocess_t1.png?raw=true) 

['Demand(t)']

(https://github.com/AshutoshDas07/ABN_HackOffv3.0/blob/master/Demand_Analysis/Preprocess_t.png?raw=true)

After preprocessing the model is trained and the data is sent to the Android Application.



