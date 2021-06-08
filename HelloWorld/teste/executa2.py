from br.gov.bnb.lmparser.exemplo import *

x = ExecutaTeste()
dic = eval(x.getDicionarioLM(r'C:\Projetos\Arquitetura\Jython\HelloWorld\teste\lm.odt'))

for key, value in dic.items():
	if key=='Localização do pacote aplicativo':
		print value
