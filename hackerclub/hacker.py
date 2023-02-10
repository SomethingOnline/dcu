from bs4 import BeautifulSoup
import requests
import pandas as pd

# GETS PRICE AND TITLE OF MUGS FROM AMAZON


HEADERS = ({"User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/109.0", "Accept-Lanuage": "en-us en;q-0.5"})

req = requests.get("https://www.amazon.co.uk/s?k=mugs&crid=1XW54C51PVYCK&sprefix=mugs%2Caps%2C65&ref=nb_sb_noss_1", headers=HEADERS)

soup = BeautifulSoup(req.text, 'html.parser')

links = soup.find_all("a", attrs={'class': "a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal"}) # Will get all the links on the page	

# For link in links ------------ Wrapping everything in a for loop will allow me to get all the links(price, title) on the page

link = links[0] # Will get the entire first link info - including classes etc


href = link.get('href') # Will get only the href - the actual link

final_link = 'https://www.amazon.co.uk' + href # Added the base url to the href

req_mug = requests.get(final_link, headers=HEADERS) # Will get the link of the first mug
parseVar = BeautifulSoup(req_mug.text, 'html.parser')
title = parseVar.find("span", attrs={'id': "productTitle"}).string.strip() # Will get the title of the first mug
price = parseVar.find("span", attrs={"class": "a-price-whole"}).text.strip() # Will get the price of the first mug


# You can get csv file from the dataframe with title and price