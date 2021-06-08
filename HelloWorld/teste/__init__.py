from br.gov.bnb.lmparser.exemplo import *

x = ExecutaTeste()
dic = eval(x.getDicionarioLM('lm.odt'))


for key, value in dic.items():
	print key