from bs4 import BeautifulSoup
import requests
import  redis
#import jsonpickle


class JobNode:
    def __init__(self,job,company,date,location,link):
        self.job = job
        self.company = company
        self.date = date
        self.location = location
        self.link = link
# a list of JSON objects
job_list = []

def printJobs():
    for item in all_links:
        JobNamestr = 'JobName'+item[1]
        JobCompanystr = 'JobCompany'+item[1]
        JobLocationstr = 'JobLocation'+item[1]
        JobDatestr = 'JobDate'+item[1]
        JobLinkstr = 'JobLink' + item[1]
        while (r_server.llen(JobNamestr) != 0 and
               r_server.llen(JobCompanystr) != 0 and
               r_server.llen(JobLocationstr) != 0 and
               r_server.llen(JobDatestr) != 0 and
               r_server.llen(JobLinkstr) != 0):
            job_name = r_server.rpop(JobNamestr).decode('utf-8')
            job_company = r_server.rpop(JobCompanystr).decode('utf-8')
            job_location = r_server.rpop(JobLocationstr).decode('utf-8')
            job_publish_date = r_server.rpop(JobDatestr).decode('utf-8')
            job_link = r_server.rpop(JobLinkstr).decode('utf-8')
            print("************************")
            print("Job : " + str(job_name))
            print("Company : " + str(job_company))
            print("Job location : " + str(job_location))
            print("Job date : " + str(job_publish_date))
            print("link : " + str(job_link))
            print("************************")


def getJobs():
    for item in all_links:
        fieldUrl = item[0]
        url = fieldUrl
        page_number = 2
        for i in range(1):
            r = requests.get(url)
            data = r.text
            soup = BeautifulSoup(data, features="html.parser")
            all_jobs = soup.find("div", {"class": "list-3--body"})
            all_jobs = soup.find_all("a", {"class": "list-3--title list-3--row"})
            for job in all_jobs:
                job_company = job.find("div", {"class": "list--cell--company"})
                job_name = job.find("div", {"class": "list-3--cell-1 list-3--cell-title-2"}).text.replace(job_company.text,'').strip()
                job_location = job.find("span", {"class": "tooltip"}).text
                job_publish_date = job.find("div", {"class": "list-3--cell-1 list-3--cell-4 align-right"}).text
                job_link = job.get('href')
                #job_node = JobNode(job_name,job_company.text,job_publish_date,job_location,job_link)
                #job_list.append(job_node)
                # writing these info to the database
                r_server.rpush('JobName'+item[1], job_name.encode('utf-8'))
                r_server.rpush('JobCompany'+item[1], job_company.text.encode('utf-8'))
                r_server.rpush('JobLocation'+item[1], job_location.encode('utf-8'))
                r_server.rpush('JobDate'+item[1], job_publish_date.encode('utf-8'))
                r_server.rpush('JobLink'+item[1], job_link.encode('utf-8'))
                #print(job_node.location)


            url = fieldUrl + "?page=" + str(page_number)
        

def getShobiddakJobs():
    url = 'https://shobiddak.com/careers?utf8=%E2%9C%93&q%5Bcountry_id_eq%5D=&q%5Bcareer_specialization_id_eq%5D=10&q%5Bworking_time_eq%5D='
    r = requests.get(url)
    data = r.text
    soup = BeautifulSoup(data, features="html.parser")
    job_table = soup.find("table", {"class": "list_ads"})
    all_jobs = job_table.find_all("tr", {"id": "row_0"})
    for job in all_jobs:
        job_company = job.find_all("td")[0].find("a").text
        job_link = "https://shobiddak.com/"+job.find_all("td")[0].find("a").get('href')
        job_specialization = job.find_all("td")[1].find("a").text
        job_city = job.find_all("td")[2].find("a").text
        job_publish_date = job.find("td",{"class":"ad-date"}).text
        r_server.rpush('JobName' + 'business', " ".encode('utf-8'))
        r_server.rpush('JobCompany' + 'business', job_company.encode('utf-8'))
        r_server.rpush('JobLocation' + 'business', job_city.encode('utf-8'))
        r_server.rpush('JobDate' + 'business', job_publish_date.encode('utf-8'))
        r_server.rpush('JobLink' + 'business', job_link.encode('utf-8'))
        #print(job_company + job_specialization + job_city + job_publish_date)
    # odd rows
    all_jobs = job_table.find_all("tr", {"id": "row_1"})
    for job in all_jobs:
        job_company = job.find_all("td")[0].find("a").text
        job_link = "https://shobiddak.com/"+job.find_all("td")[0].find("a").get('href')
        job_specialization = job.find_all("td")[1].find("a").text
        job_city = job.find_all("td")[2].find("a").text
        job_publish_date = job.find("td",{"class":"ad-date"}).text
        r_server.rpush('JobName' + 'business', " ".encode('utf-8'))
        r_server.rpush('JobCompany' + 'business', job_company.encode('utf-8'))
        r_server.rpush('JobLocation' + 'business', job_city.encode('utf-8'))
        r_server.rpush('JobDate' + 'business', job_publish_date.encode('utf-8'))
        r_server.rpush('JobLink' + 'business', job_link.encode('utf-8'))
        #print(job_company + job_specialization + job_city + job_publish_date)

it_jobs_link = 'https://www.jobs.ps/categories/it-jobs'
healthcare = 'https://www.jobs.ps/categories/healthcare-jobs'
social = 'https://www.jobs.ps/categories/social-science-jobs'
marketing = 'https://www.jobs.ps/categories/sales-marketing-jobs'
communication = 'https://www.jobs.ps/categories/public-relation-jobs'
media = 'https://www.jobs.ps/categories/press-media-jobs'
other = 'https://www.jobs.ps/categories/others-jobs'
operation ='https://www.jobs.ps/categories/operations-jobs'
law = 'https://www.jobs.ps/categories/legal-jobs'
hotel = 'https://www.jobs.ps/categories/hospitality-tourism-jobs'
graphic_design = 'https://www.jobs.ps/categories/graphic-design-jobs'
lanuages ='https://www.jobs.ps/categories/languages-and-translation-jobs'
account = 'https://www.jobs.ps/categories/accounting-finance-jobs'
engineering = 'https://www.jobs.ps/categories/engineering-jobs'
education  = 'https://www.jobs.ps/categories/education-training-jobs'
art = 'https://www.jobs.ps/categories/culture-arts-jobs'
business = 'https://www.jobs.ps/categories/business-administration-jobs'
all_links = ( (it_jobs_link,'it'),  (healthcare,'healthcare'),(social,'social') ,(marketing,'marketing') ,(communication,'communication') ,(media,'media') ,(other,'other'),(operation,'operation') ,(law,'law')
,(hotel,'hotel') ,(graphic_design,'graphicdesign') ,(lanuages,'languages') ,(account,'account'),(engineering,'engineering') ,(education,'education'),(art,'art'),(business,'business')  )

url = healthcare

r_server = redis.Redis("localhost")


getShobiddakJobs()
getJobs()
# printJobs()
# r_server.lpush('LanguageList', "Kotlin".encode('utf-8'))
# r_server.lpush('LanguageList', "Java".encode('utf-8'))
# r_server.lpush('LanguageList', "C++".encode('utf-8'))
# r_server.lpush('LanguageList', "C#".encode('utf-8'))
# r_server.set("name","ata")

print("Finished");









