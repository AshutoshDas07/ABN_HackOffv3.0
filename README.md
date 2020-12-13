# Fashion Trend Predictor App
This app is made to predict trends and demands of various clothing styles. This app is targeted to retailers only and will save them from huge losses.

## Avantages of Predictiong fashion trends
* Allow retailers to enhance their logistics for storage/shipping of clothes.
* Right now, retailers use sales along with results from fashion shows/blogs to determine what clothes would be useful for fashion.
* This project could add a new dimension of analytics for such retailers (being able to use social media to predict demand possibly).
* This project will contribute towards Environment Conservation by minimizing the textile waste.

## How this project is set up ?
**Predicting_Trend** folder contains the Deep Learning part of the app that is used to predict trends.

**This Current** folder contains the UI part of the app.

**Demand_Analysis** folder contains the LSTM network which is used to analyse the demands of various clothing styles.

# Predicting Trends
This part is an effort to predict fashion trends over time using machine learning. Currently, We are able to classify different types of clothing (Shirts, Skirts, Pants, Dress) using images webscraped from chictopia.com, instagram and training a model built using Keras.

## How is this Predicting Trend part set up ?
Currently, this project is split into several files to make prototyping easier. Current workflow:

`webscraper.py --> csvDownload.py --> preprocessing.py --> Trend_Prediction.ipynb`

* `webscraper.py` webscrapes chictopia.com for images and tags.
* `csvDownload.py` actually downloads the scraped images which are fed into.
* `preprocessing.py` to perform image preprocessing.
* Finally, `Trend_Prediction.ipynb` is run to actually train the model and test the model.

## Preprocessing the Web-Scraped Images
We used [BeautifulSoup](https://pypi.org/project/beautifulsoup4/) to parse webpages. Then, We downloaded the images and start preprocessing.

Let's say we load the following image in `preprocessing.py` :

![airy-deals-dress_4002018-05-24](https://user-images.githubusercontent.com/42767796/102005040-d3295c00-3d3b-11eb-81c2-1a86df6e792a.jpg)

Then we get the following preprocessed image :

![airy-deals-dress_4002018-05-24](https://user-images.githubusercontent.com/42767796/102005080-0e2b8f80-3d3c-11eb-81e5-343fabb751a4.jpg)

We removed the background (everything but humans) using [DeepLabv3+](https://github.com/bonlime/keras-deeplab-v3-plus).

## Training
`Trend_Prediction.ipynb` first creates a pandas dataset using the CSVs from `webscraping.py` and then constructs a 3D numpy array of the arrays created from `preprocessing.py`. After this, training occurs.

Our current model is a 'Convolutional Neural Network Model' having last layer as a softmax layer. Optimizer is Adam.

Result after training:

![Screenshot (93)](https://user-images.githubusercontent.com/42767796/102005284-a9713480-3d3d-11eb-99d4-d44c93bf6f7b.png)

These results are pretty good considering a small and potentially noisy dataset (~1200 images). For further improvements, We might use a GAN (Generational-Adversarial Network) which has been proven to do better for fashion classification and add more images to the dataset.

## LSTM Network ##
After the CNN model has been trained, it predicts the trending clothing styles and after that along with the help of time-series data a LSTM model is trained which then helps to predict the demand of those trending clothing styles in the market. 
The time-series data happens to be from a retail store.

## Final Application ##
![](https://github.com/AshutoshDas07/ABN_HackOffv3.0/blob/master/App%20Screenshots/WhatsApp%20Image%202020-12-13%20at%203.00.25%20PM.jpeg)

This is the Welcome Screen of App

![](https://github.com/AshutoshDas07/ABN_HackOffv3.0/blob/master/App%20Screenshots/WhatsApp%20Image%202020-12-13%20at%203.00.25%20PM%20(1).jpeg)

We have provided the Phone Authentication powered by Google Firebase for the Retailer User which can help him connect and talk to mannufacturers
![](https://github.com/AshutoshDas07/ABN_HackOffv3.0/blob/master/App%20Screenshots/WhatsApp%20Image%202020-12-13%20at%203.00.25%20PM%20(2).jpeg)
Slider of the App starting with Men's Section


![](https://github.com/AshutoshDas07/ABN_HackOffv3.0/blob/master/App%20Screenshots/WhatsApp%20Image%202020-12-13%20at%203.00.26%20PM%20(1).jpeg)
![](https://github.com/AshutoshDas07/ABN_HackOffv3.0/blob/master/App%20Screenshots/WhatsApp%20Image%202020-12-13%20at%203.00.26%20PM.jpeg)
![](https://github.com/AshutoshDas07/ABN_HackOffv3.0/blob/master/App%20Screenshots/WhatsApp%20Image%202020-12-13%20at%203.00.26%20PM%20(2).jpeg)
![](https://github.com/AshutoshDas07/ABN_HackOffv3.0/blob/master/App%20Screenshots/WhatsApp%20Image%202020-12-13%20at%203.00.27%20PM%20(1).jpeg)
![](https://github.com/AshutoshDas07/ABN_HackOffv3.0/blob/master/App%20Screenshots/WhatsApp%20Image%202020-12-13%20at%203.00.27%20PM%20(2).jpeg)
![](https://github.com/AshutoshDas07/ABN_HackOffv3.0/blob/master/App%20Screenshots/WhatsApp%20Image%202020-12-13%20at%203.00.27%20PM.jpeg)


![](https://github.com/AshutoshDas07/ABN_HackOffv3.0/blob/master/App%20Screenshots/WhatsApp%20Image%202020-12-13%20at%203.00.27%20PM%20(3).jpeg)
**These are the trending graphs corresponding to Shirts ^

![](https://github.com/AshutoshDas07/ABN_HackOffv3.0/blob/master/App%20Screenshots/WhatsApp%20Image%202020-12-13%20at%203.00.28%20PM%20(1).jpeg)
**These are the trending graphs corresponding to T-Shirts ^

![](https://github.com/AshutoshDas07/ABN_HackOffv3.0/blob/master/App%20Screenshots/WhatsApp%20Image%202020-12-13%20at%203.00.28%20PM.jpeg)

