package hidden_funtion.goodorbad;





import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class Detection {

	public static String getDetectionResult(String name, HttpServletRequest request) {

		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		// 读取领导人信息
		if(name.equals("习近平")){
		 switch (random.nextInt(3)) {
		case 0:
			sb.append("小鬼，你不去看书学习，在这玩这个游戏？！");
			return sb.toString();
        case 1:
        	sb.append("本科1975－1979年，清华大学化工系基本有机合成专业学习，博士，2001年，清华法学专业");
			return sb.toString();
		default:
			sb.append("每年都有许多博士通过论文答辩，但这些论文一般都是针对某一学术领域尚待破解的课题提出自己的见解，对于许多学子来说，通过答辩，获得博士学位是他们的追求，至于所提出的“学术见解”能否走出书斋并不是最在意的。也就是说，许多学子，包括学者，学术与实践往往存在很长一段距离。");
			sb.append("\n").append("然而，在清华大学图书馆的学位论文阅览室，现在可以查询到习近平一篇十三年前的博士论文——《中国农村市场化研究》，该论文共169页，指导教师为清华大学经济学研究所教授刘美珣。习近平时任福建省省长，对于要不要取消户籍限制，当时学界和理论界存在争议，他在论文中坚持认为，取消城乡二元户籍制度，是历史发展的必然趋势，政府应理智而勇敢地面对这一现实。现在，学界和理论界都不要争了！据新华社7月30日消息，国务院日前印发《国务院关于进一步推进户籍制度改革的意见》。意见指出，严格控制特大城市人口规模，改进城区人口500万以上的城市现行落户政策，建立完善积分落户制度，取消农业人口与非农业人口的区别。 这个意义，不亚于取消农业税，习近平当年的梦想，如今终于变为现实，停留在学术层面的成果终于成为国家的大政方针。");
			sb.append("\n").append("与一些纯为获得博士学位的学子不同，习近平提出取消城乡二元户籍制度，是他在从政过程中积累的思考，十三年间，习近平从福建调到浙江、上海，再到中央任职，他在不同的位置上，都曾多次表示要推动户籍改革，也就是说，当年他不是为了论文而论文，取消城乡二元户籍制度是他的一种施政理想。现在我们初步梳理一下习近平的博士论文中的主要论点，即可发现，这些论点与国务院公布的户籍制度改革意见的核心内容是一致的。例如，习近平在论文中希望“坚决剔除粘附在户籍上的社会经济差别”，他说，“无论从农村市场化建设的角度看，还是从市场经济发展和实现现代化的要求看，取消在计划经济体制下形成的从人们出生之日起就分成非农业人口和农业人口两种不同身份的户籍制度，是历史发展的必然趋势，政府应理智而又勇敢地面对这一现实，大胆进行户籍制度改革，坚决剔除粘附在户籍关系上的种种社会经济差别，彻底消除由户籍制度造成的城乡劳动力市场的分割。”而国务院的户籍制度改革意见中，有关建立居住证制度，保证居住证持有人享有与当地户籍人口同等的劳动就业、基本公共教育、基本医疗卫生服务、计划生育服务、公共文化服务、证照办理服务等权利；以连续居住年限和参加保险年限等为条件，让居住证持有人享有与当地户籍人口同等职业教育资助、社会福利等权利，这些举措正是习近平提出的“坚决剔除粘附在户籍上的社会经济差别”的具体体现。又如，习近平在论文中提出“按城市规模不同层次推进”，他说，“改革要慎重、稳妥，分阶段积极推进，可先让那些符合一定的条件和要求，诸如有稳定的收入来源，居住时间达到一定年限的进城经商和务工的农民，获得合法的居住身份。”他的论文还提出了户籍改革“路线图”——可在一些小城镇实行不再有城乡限制的新的户籍管理制度，取得局部突破后，再分为中等城市、大城市和特大城市等不同层次循序推开。而国务院在“总体要求”中就提出：坚持积极稳妥、规范有序。立足基本国情，积极稳妥推进，优先解决存量，有序引导增量，合理引导农业转移人口落户城镇的预期和选择。一篇尘封在高校图书馆的博士论文，终于成为改变一个国家城乡结构的理论指导，并将深深影响数亿农业人口的命运，这样的论文，怎不说牛？");
			return sb.toString();
		}
		}else if (name.equals("李克强")) {
			sb.append("1977年底，李克强荣幸成爲“七七级”的一员。后来，李克强回忆：“在填写高考志愿之前，我曾收到一位邂逅相识的学者的来信。他早年毕业于北大，深以爲那里有知识的金字塔，因而在信中告诫我，要珍惜十年一遇的机会，把北大作爲唯一的选择。当时的我多数时间是和乡亲们一起爲生存而忙碌，几乎不敢有奢望。在生存欲和求知欲的交织驱动下，我还是在第一志愿填写了本省一所师范学院的名字-据说在师范学院读书是不必付钱的。即便如此，我对北大依然存有难以抑制的向往，于是又在第二志愿的栏里填下了北大。大概是因爲北大有优先权，她没有计较我这几乎不敬的做法，居然录取了我。”1978年12月，安徽省凤阳县小岗村18户农民代表敢冒天下之大不韪，联名签订了分田和包産到户的契约，由此揭开了中国农村经济体制改革的序幕。而这一年的3月，李克强已带着憧憬告别了4年的插队生活，离开了日后有中国农村改革“大包干”发源地之誉的凤阳，走进北京大学。老师称他们是“黄埔一期”分高学优、根正苗红是当时法科学生的选拔标准。尽管政治气候回暖，开始解冻的法科仍是绝密专业，颇有「阵地」意味。所有的法律教材封皮上都有“绝密”字样，军人、农村支部书记、中小学教员、地方党政机关工作人员-法律专业聚集了又红又专的各路英雄。北大法律系拥有良好的师资和设备，名师中最着名的当推学贯中西的宪法行政法学家龚祥瑞。龚祥瑞早年专治政治学，曾赴英国深造，对西方政制、法治有亲身体味，兼具政治学与法学的素养。聪明勤奋的李克强很快成爲龚祥瑞的得意门生。李克强也崇拜兼具比较宪法和西方政治学素养的龚祥瑞。“文革”期间，公检法被砸烂，宪法沦爲废纸。教学中一些老师对宪法话题噤若寒蝉。然而，龚祥瑞在课堂上畅谈民主宪政真义，让李克强等深深感受到“恰似天降甘霖”。在龚祥瑞那里，李克强知道了何谓真正的自由主义和宪政精神。龚祥瑞主张，宪法具有最高性，即使最高权力机关也必须遵守。在宪法之上再也没有无所不能、无所不在的“上帝”或“正确领导”。龚祥瑞告诉李克强他们，宪政道路就是法治的道路，法治是走向民主的第一步。这些宪政主张，对于刚刚经历过“文革”的李克强犹如石破天惊，也让他热血沸腾。在龚祥瑞的引领下，李克强渐渐着重转向外国宪法和比较政治的学习。");
			return sb.toString();
		}

		// 读取Txt文档中记录的数据情况
		List<String> infoList = GetAllTxtInfo.getTxtAll(request);

		sb.append(name + "蕴含着极大的能量，所以您的等级为：").append(infoList.get(random.nextInt(infoList.size() + 1)));

		return sb.toString();
	}

	public static String getAllLevel(HttpServletRequest request) {
		// 读取Txt文档中记录的数据情况
		List<String> infoList = GetAllTxtInfo.getTxtAll(request);

		StringBuilder sb = new StringBuilder();
		sb.append("----所有等级情况如下----").append("\n");
		for (String s : infoList) {
			sb.append(s).append("\n");
		}

		return sb.toString();
	}

	// 检测输入的是否是2-4个汉字

	public static boolean isName(String name) {

		// 判断2-4个汉字的正则表达式
		boolean result = false;
		String nameRegex = "[\u4e00-\u9fa5]{2,4}";
		Pattern p = Pattern.compile(nameRegex);
		Matcher m = p.matcher(name);
		if (m.matches()) {
			result = true;
		}

		return result;
	}

}
