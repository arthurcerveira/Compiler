class CodeGen{
	
	int geraCodigo (ArvoreSintatica arv)
	{
		return geraCodigo2(arv);
	}
	int geraCodigo2 (ArvoreSintatica arv)
	{

	if (arv instanceof Mult)
		return geraCodigo2(((Mult) arv).arg1) * geraCodigo2(((Mult) arv).arg2);

	if (arv instanceof Soma)
		return geraCodigo2(((Soma) arv).arg1) + geraCodigo2(((Soma) arv).arg2);

	if (arv instanceof Sub)
		return geraCodigo2(((Sub) arv).arg1)  - geraCodigo2(((Sub) arv).arg2);

	if (arv instanceof Div)
		return geraCodigo2(((Div) arv).arg1) / geraCodigo2(((Div) arv).arg2);

	if (arv instanceof Num)
		return ((Num) arv).num;

	return 0;
	}
}
