import requests
from fake_useragent import UserAgent
from bs4 import BeautifulSoup
import pymysql
import time
import random
#打开数据库连接
conn = pymysql.connect("localhost", "root", "root", "seckill")

headers={
    'User-Agent': UserAgent().random
}

url= "https://list.tmall.com/search_product.htm?spm=875.7931836/B.category2016015.1.13af4265iTAVT4&q=%CA%D6%BB%FA&vmarket=&from=mallfp..pc_1_searchbutton&acm=lb-zebra-148799-667863.1003.4.708026&type=p&scm=1003.4.lb-zebra-148799-667863.OTHER_14561662186585_708026"
r = requests.get(url, headers=headers, timeout=10)
soup=BeautifulSoup(r.text, "lxml")

def product(soup):
  list=soup.select(".product-iWrap")
  for l in list[10:30]:
    name=l.select(".productTitle")[0].a["title"]
    img=l.select(".productImg-wrap img")[0]
    img_url=img["data-ks-lazyload"]
    index=img_url.rindex("!")
    img=img_url[index+1:]
    if img_url[:2]=="//":
      img_url="http:" +img_url
    r=requests.get(img_url, headers=headers, timeout=10)
    path="D:/picture/seckill/" +img
    with open(path, "wb") as f:
      f.write(r.content)

    price=l.select(".productPrice")[0].em["title"]
    evaluate=l.select(".productStatus span a")[0].text
    store=l.select(".productShop .productShop-name")[0].text
    stock=random.randint(500,2000)

    #使用cursor()方法获取操作游标
    cursor=conn.cursor()
    sql="INSERT INTO goods(name, img, price, evaluate, store, stock) VALUES(%s, %s, %s, %s, %s, %s)"
    cursor.execute(sql, (name, img, price, evaluate, store, stock))
  #提交到数据库执行
  conn.commit()
  conn.close()
if __name__ == "__main__":
  product(soup)
