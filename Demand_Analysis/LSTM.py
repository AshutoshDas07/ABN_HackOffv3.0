
from pandas import read_csv

from keras.models import Sequential
from keras.layers import Dense
from keras.layers import LSTM

dataset = read_csv('time_series_retail.csv')
values = dataset.values
print(len(values))
types= values[:,0]
#print(types)
shirt_type = types[0:10]
skirt_type = types[10:20]
jacket_type = types[20:30]
denims_type = types[30:40]
shirt_values = values[0:10,1:]
skirt_values = values[10:20,1:]
jacket_values = values[20:30,1:]
denims_values = values[30:40,1:]
#print(shirt_values)
shirt_t1 = shirt_values[0:9,:]
shirt_t = shirt_values[1:10,-1:]
skirt_t1 = skirt_values[0:9,:]
skirt_t = skirt_values[1:10,-1:]
jacket_t1 = jacket_values[0:9,:]
jacket_t = jacket_values[1:10,-1:]
denims_t1 = denims_values[0:9,:]
denims_t = denims_values[1:10,-1:]
print(denims_t1)
print()
print(denims_t)

train_X_shirt, train_y_shirt = shirt_values[:7,:-1], shirt_values[:7,-1]
test_X_shirt, test_y_shirt = shirt_values[8:10, :-1], shirt_values[8:10,-1]

train_X_skirt, train_y_skirt = skirt_values[:7,:-1], skirt_values[:7,-1]
test_X_skirt, test_y_skirt = skirt_values[8:10, :-1], skirt_values[8:10,-1]

train_X_jacket, train_y_jacket = jacket_values[:7,:-1], jacket_values[:7,-1]
test_X_jacket, test_y_jacket = jacket_values[8:10, :-1], jacket_values[8:10,-1]

train_X_denims, train_y_denims = denims_values[:7,:-1], denims_values[:7,-1]
test_X_denims, test_y_denims = denims_values[8:10, :-1], denims_values[8:10,-1]



model = Sequential()
model.add(LSTM(50, input_shape=(train_X_shirt.shape[1], train_X_shirt.shape[2])))
model.add(Dense(1))
model.compile(loss='mae', optimizer='adam')
history = model.fit(train_X_shirt, train_y_shirt, epochs=50, batch_size=72, validation_data=(test_X_shirt, test_y_shirt), verbose=2, shuffle=False)

model = Sequential()
model.add(LSTM(50, input_shape=(train_X_skirt.shape[1], train_X_skirt.shape[2])))
model.add(Dense(1))
model.compile(loss='mae', optimizer='adam')
history = model.fit(train_X_skirt, train_y_skirt, epochs=50, batch_size=72, validation_data=(test_X_skirt, test_y_skirt), verbose=2, shuffle=False)

model = Sequential()
model.add(LSTM(50, input_shape=(train_X_shirt.shape[1], train_X_shirt.shape[2])))
model.add(Dense(1))
model.compile(loss='mae', optimizer='adam')
history = model.fit(train_X_jacket, train_y_jacket, epochs=50, batch_size=72, validation_data=(test_X_jacket, test_y_jacket), verbose=2, shuffle=False)

model = Sequential()
model.add(LSTM(50, input_shape=(train_X_denims.shape[1], train_X_denims.shape[2])))
model.add(Dense(1))
model.compile(loss='mae', optimizer='adam')
history = model.fit(train_X_denims, train_y_denims, epochs=50, batch_size=72, validation_data=(test_X_denims, test_y_denims), verbose=2, shuffle=False)



