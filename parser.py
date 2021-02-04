import struct
import folium
from folium import plugins
import sys
import datetime
from shapely.geometry import Point,Polygon

mainarea = [(37.77831, 126.18382),
    (37.74873, 126.18708),
    (37.71737, 126.1603),
    (37.71221, 126.11103),
    (37.65814, 126.01679),
    (37.71452, 125.75003),
    (37.69164, 125.695),
    (37.6819, 125.51671),
    (37.64919, 125.42629),
    (37.52702, 125.47099),
    (37.44529, 125.5524),
    (37.41472, 125.62956),
    (37.39249, 125.71793),
    (37.39941, 125.79835),
    (37.4151, 125.84564),
    (37.40935, 125.86774),
    (37.30198, 125.7526),
    (37.1809, 125.71321),
    (37.16989, 125.63493),
    (37.11529, 125.5612),
    (37.05922, 125.51734),
    (36.69726, 125.30474),
    (36.64859, 125.28903),
    (36.59141, 125.28843),
    (36.51729, 125.32079),
    (36.51695, 125.32066),
    (36.01484, 125.75089),  
    (35.87928, 125.81028),
    (35.7971, 125.83607),
    (35.67822, 125.84753),
    (35.54745, 125.80019),
    (35.44969, 125.77601),
    (34.85206, 125.00579),
    (34.81831, 124.9791),
    (34.73265, 124.93858),
    (34.10868, 124.83644),
    (34.00244, 124.8567),
    (33.9408, 124.90185),
    (33.88452, 124.97429),
    (33.85146, 125.06166),
    (33.69949, 126.05885),
    (33.58059, 126.08133),
    (33.48887, 125.99756),
    (33.4068, 125.92478),
    (33.31131, 125.9016),
    (33.34573,125.90658),
    (33.31009,125.90229),
    (33.27213,125.90813),
    (33.23136,125.92572),
    (33.13999,125.98924),
    (33.11836,126.01061),
    (33.09341,126.01808),
    (33.07414,126.03078),
    (33.05486,126.03584),
    (32.99146,126.07241),
    (32.93781,126.1439),
    (32.91735,126.19308),
    (32.91,126.2275),
    (32.90964,126.30612),
    (32.92002,126.35539),
    (32.94962,126.41461),
    (32.97756,126.448),
    (33.01521,126.4789),
    (33.01068,126.51916),
    (33.01363,126.55778),
    (33.02248,126.59752),
    (33.01752,126.6437),
    (33.01939,126.71339),
    (33.04529,126.78514),
    (33.06572,126.81733),
    (33.09729,126.85166),
    (33.11872,126.92968),
    (33.14409,126.97895),
    (33.16766,127.01337),
    (33.19668,127.0435),
    (33.22217,127.06392),
    (33.24285,127.07268),
    (33.29689,127.12358),
    (33.34265,127.15499),
    (33.38702,127.17344),
    (33.42392,127.19653),
    (33.46562,127.21104),
    (33.54118,127.21567),
    (33.59625,127.19293),
    (33.64956,127.14975),
    (33.68085,127.10272),
    (33.70235,127.04598),
    (33.71056,126.99225),
    (33.75874,126.91604),
    (33.83335,127.66285),
    (33.8516,127.7243),
    (33.8821,127.78473),
    (34.12147,128.00171),
    (34.34145,128.81813),
    (34.50797,128.79478),
    (34.94702,129.1024),
    (35.03927,129.17622),
    (35.13114,129.26891),
    (35.12889,129.46701),
    (35.139,129.46735),
    (35.18419,129.49036),
    (35.20327,129.52675),
    (35.2358,129.56142),
    (35.28206,129.5937),
    (35.33557,129.60915),
    (35.3633,129.64245),
    (35.39801,129.67094),
    (35.47102,129.69257),
    (35.54424,129.7221),
    (35.58725,129.72141),
    (35.62493,129.71386),
    (35.7454,129.74579),
    (35.83619,129.78424),
    (35.89128,129.78493),
    (35.93743,129.81445),
    (35.98995,129.83402),
    (36.0713,129.83437),
    (36.16061,129.80038),
    (36.20273,129.76604),
    (36.2451,129.71523),
    (36.28607,129.63215),
    (36.31983,129.66099),
    (36.39393,129.68468),
    (36.50384,129.70425),
    (36.5899,129.6888),
    (36.61332,129.70493),
    (36.65988,129.72244),
    (36.77299,129.73206),
    (36.90488,129.68845),
    (36.93782,129.67266),
    (37.00694,129.67197),
    (37.02942,129.68021),
    (37.06203,129.68296),
    (37.1105,129.67609),
    (37.15567,129.65549),
    (37.19205,129.62357),
    (37.26859,129.62597),
    (37.35924,129.57207),
    (37.40453,129.5295),
    (37.42525,129.50409),
    (37.50292,129.45911),
    (37.52252,129.43302),
    (37.58513,129.38221),
    (37.59247,129.37122),
    (37.62375,129.36848),
    (37.67757,129.33895),
    (37.7118,129.31046),
    (37.77967,129.2775),
    (37.81602,129.24145),
    (37.82633,129.21879),
    (37.85236,129.20128),
    (37.87675,129.17416),
    (37.89707,129.14291),
    (37.93201,129.11613),
    (37.97018,129.07356),
    (38.01348,129.0461),
    (38.05526,128.99855),
    (38.06715,128.99855),
    (38.13726,128.94327),
    (38.05526,128.99855),
    (38.16938,128.9043),
    (38.18949,128.89109),
    (38.13726,128.94327),
    (38.21429,128.86941),
    (38.25072,128.85969),
    (38.32369,128.82451),
    (38.46822,128.73751),
    (38.51109,128.70726),
    (38.56956,128.67651),
    (38.61757,128.65606),
    (38.62332,128.37447),
    (38.61531,128.35902),
    (37.77832,126.18382)]
Dokdo = [(37.03778,131.88332),
    (37.04757,131.95258),
    (37.06573,132.00768),
    (37.09407,132.05918),
    (37.12344,132.09558),
    (37.14793,132.11549),
    (37.17427,132.13145),
    (37.20299,132.14227),
    (37.21741,132.14596),
    (37.23491,132.14699),
    (37.26517,132.14587),
    (37.29727,132.13583),
    (37.33461,132.11669),
    (37.36872,132.08639),
    (37.39321,132.05592),
    (37.41503,132.01936),
    (37.42777,131.98975),
    (37.43841,131.9573),
    (37.44638,131.91301),
    (37.44904,131.87276),
    (37.44849,131.83062),
    (37.44277,131.79088),
    (37.42818,131.73955),
    (37.41216,131.70247),
    (37.39375,131.67209),
    (37.37282,131.64668),
    (37.34976,131.62462),
    (37.33263,131.61235),
    (37.2929,131.59269),
    (37.2677,131.58626),
    (37.24092,131.58514),
    (37.21365,131.58737),
    (37.19724,131.59141),
    (37.1809,131.59724),
    (37.15833,131.60866),
    (37.13014,131.63106),
    (37.09736,131.66651),
    (37.06915,131.71629),
    (37.06004,131.73835),
    (37.04709,131.78289),
    (37.04202,131.81053),
    (37.03771,131.88314)]
ulleungdo = [(37.25602,130.92604),
    (37.26586,130.9736),
    (37.28464,131.02449),
    (37.30622,131.06106),
    (37.32833,131.09153),
    (37.34143,131.11204),
    (37.36634,131.1426),
    (37.38837,131.16217),
    (37.42757,131.18465),
    (37.44079,131.18869),
    (37.45592,131.19942),
    (37.49093,131.21195),
    (37.50809,131.21624),
    (37.52729,131.21778),
    (37.54961,131.21718),
    (37.57213,131.21221),
    (37.59397,131.20431),
    (37.6143,131.19435),
    (37.63442,131.17847),
    (37.6506,131.16508),
    (37.66704,131.1462),
    (37.68518,131.12406),
    (37.70185,131.10045),
    (37.72105,131.06044),
    (37.72979,131.03808),
    (37.74471,130.9884),
    (37.74946,130.96476),
    (37.75214,130.9371),
    (37.75326,130.90856),
    (37.75207,130.87704),
    (37.74903,130.84936),
    (37.74084,130.8099),
    (37.73594,130.77631),
    (37.72692,130.74078),
    (37.72137,130.72319),
    (37.71481,130.70741),
    (37.70583,130.67587),
    (37.69117,130.64145),
    (37.6829,130.62502),
    (37.67496,130.61184),
    (37.66711,130.60019),
    (37.65792,130.58809),
    (37.64965,130.57852),
    (37.63328,130.56129),
    (37.61765,130.54914),
    (37.60177,130.53854),
    (37.57331,130.52517),
    (37.56157,130.52161),
    (37.53656,130.51629),
    (37.51019,130.5158),
    (37.49786,130.51691),
    (37.47591,130.52127),
    (37.45493,130.52846),
    (37.44423,130.53118),
    (37.43128,130.53532),
    (37.41416,130.54266),
    (37.39999,130.55112),
    (37.38765,130.56),
    (37.36867,130.57547),
    (37.34669,130.59704),
    (37.31763,130.63808),
    (37.30463,130.66304),
    (37.29461,130.68742),
    (37.27839,130.7314),
    (37.26326,130.78616),
    (37.2557,130.82721),
    (37.25254,130.87463),
    (37.25602,130.92605)]

baengnyeongdo = [(38.04944,124.38017),
    (37.99332,124.37365),
    (37.9092,124.37304),
    (37.83989,124.41133),
    (37.78652,124.40806),
    (37.74215,124.41648),
    (37.69394,124.44506),
    (37.65712,124.48119),
    (37.59682,124.57552),
    (37.56819,124.65989),
    (37.56635,124.78529),
    (37.58832,124.8779),
    (37.63225,124.94116),
    (37.68708,124.97772),
    (37.76637,124.867),
    (37.99961,124.85026),
    (38.04985,124.63371),
    (37.99332,124.37364)]

Mainarea_poly = Polygon(mainarea)
Dokdo_poly = Polygon(Dokdo)
Ulleungdo_poly = Polygon(ulleungdo)
Baengnyeongdo_poly = Polygon(baengnyeongdo)



def AnalsisArgument(Track_Name,Tracklist,MarkPoint_list,timelist) :
    take_list = []
    re_list = []
    ttime_list = []
    i = 0
    for each in Tracklist :
        if each == Tracklist[-1] :
            break
        re_list=MutalAnalsis(each,Tracklist[i+1],MarkPoint_list,timelist)[0]
        take_list.extend(re_list) 
        ttime_list.extend(MutalAnalsis(each,Tracklist[i+1],MarkPoint_list,timelist)[1])
        i += 1             
    
    if (not take_list) == False :
        print(Track_Name+"의 생성시간은 ")
        print(str(ttime_list[0]) + " 으로 예상됩니다.")

def MutalAnalsis(a,b,Mark_list,timelist) : 
    Data1=Point(a)
    Data2=Point(b)
    currupt_list = []
    Ptime_list = []
    i = 0
    for each in Mark_list :
        Data3 = Point(each)
        diRe= Data1.distance(Data2)
        bc= Data2.distance(Data3)
        ac= Data1.distance(Data3)
        Result = round(diRe,4)
        Result2 = round(bc+ac,4)
        if Result == Result2 :
            currupt_list.append(each)
            Ptime_list.append(timelist[i])
        i+= 1
    return currupt_list,Ptime_list

def area_check(GPSdata):

    Ctarget = Point(GPSdata)
    
    Cvalue=Ctarget.within(Mainarea_poly)
    Dvalue=Ctarget.within(Dokdo_poly)
    Uvalue=Ctarget.within(Ulleungdo_poly)
    Bvalue=Ctarget.within(Baengnyeongdo_poly)

    if Cvalue == True :
        return True
    elif Dvalue == True:
        return True
    elif Uvalue == True:
        return True
    elif Bvalue == True:
        return True
    else :
        return False

    
# 항적데이터 관련있는것만 뽑을건지 체크 / False가 관련있는것만 뽑음
option_1 = True

my_map = folium.Map(location=[37.95483, 123.95325], zoom_start=8)
folium.plugins.MousePosition().add_to(my_map)

fg = folium.FeatureGroup(name='Track')
my_map.add_child(fg)
wg = folium.FeatureGroup(name='Way')
my_map.add_child(wg)
mg = folium.FeatureGroup(name='Mark')
my_map.add_child(mg)
msgg = folium.FeatureGroup(name='Message')
my_map.add_child(msgg)
rt = folium.FeatureGroup(name ='Route')
my_map.add_child(rt)

def lati_accumulate(degree, minute, decimal):
    v = -1 if int(decimal) <= 1000 else 1
    return int(v * (30000 * int(degree) + 500 * int(minute) + (int(decimal) - 1000 * v - 1000) / 2))

def longi_accumulate(degree, minute, decimal):
    v = 1 if int(decimal) <= 1000 else -1
    return int((30000 * int(degree) + 500 * int(minute) + (int(decimal) - 1000 * (1 - v)) / 2) * v)

def reverse_gps(num):
    degree = int(num / 30000)
    minute = int((num - (degree * 30000)) / 500)
    decimal = 2 * ((num - (degree * 30000) - (minute * 500)))
    return abs(degree + ((minute + (decimal / 1000)) / 60)) # translate dd mm.mmm to dd.ddddd

def Route_Carve(WayPointGPS_list,filepath):
    data = open(filepath+'\\naviline.dat', 'rb')
    yeah = data.read(0x84)
    while yeah:
        routelist = []
        to = '<'
        RouteName = yeah[0x00:0x08].decode('euc-cn').replace('\0', '')
        two = struct.unpack('< hbbbbb', yeah[0x14: 0x1B])
        Routelen = len(yeah[0x20:0x7F].replace(b'\x00',b''))
        RouteIWP = yeah[0x20:0x7F].replace(b'\x00',b'')
        buffsize = 'b' * Routelen
        to = '<'+ buffsize
        RwayPoint = struct.unpack_from(to,RouteIWP)
        Yard = yeah[0x84:0x8C].decode('euc-cn')
        for each in RwayPoint:
            routelist.append(WayPointGPS_list[each])
        print(routelist)
        Write_Route(routelist,RouteName)
        yeah = data.read(0x84)

def Write_Track(Track_Name,Track_Num, GPS_list, option1):
    n = 1
    #그룹 이름
    group_str = str("Track_"+Track_Num)
    group = plugins.FeatureGroupSubGroup(fg, group_str, show=option1) 
    my_map.add_child(group)
    inside_list =[]
    outside_list = []
    last_is_in_area = True
    tmp_list = []
    for each in GPS_list:
        if area_check(each):
            if not last_is_in_area:
                tmp_list.append(each)
                outside_list.append(tmp_list)
                tmp_list = []

            tmp_list.append(each)
            last_is_in_area = True
                
            folium.CircleMarker(
                location = each,
                fill='true',
                radius = 2,
                tooltip= Track_Name + " : " +str(n),
                fill_color = 'red',
                color = 'clear',
                fill_opacity=3
            ).add_to(group)
        else :
            if last_is_in_area:
                tmp_list.append(each)
                inside_list.append(tmp_list)
                tmp_list = []

            tmp_list.append(each)
            last_is_in_area = False

            folium.CircleMarker(
                location=each,
                fill='true',
                radius = 2,
                tooltip= Track_Name+ " : " + str(n),
                fill_color='blue',
                color = 'clear',
                fill_opacity=3
            ).add_to(group)

        n+=1
    else:
        if area_check(each):
            inside_list.append(tmp_list)
        else:
            outside_list.append(tmp_list)

    # add lines

    for outside in outside_list:
        attr = {'font-weight': 'regular', 'font-size': '20', 'color' : 'red'}
        try:
            line = folium.PolyLine(outside, color="green", weight=2.5, opacity=1,icons='arrow').add_to(group)        
        except ValueError as ve:
            #print(ve)
            continue
        plugins.PolyLineTextPath(
            line,
            '\u276F              ',
            repeat=True,
            offset=7,
            fill_opacity=3,
            attributes=attr
        ).add_to(group)
    
    for inside in inside_list:
        attr = {'font-weight': 'regular', 'font-size': '20', 'color' : 'red'}
        try:
            line = folium.PolyLine(inside, color="red", weight=2.5, opacity=1,icons='arrow').add_to(group)
        except ValueError as ve:
            #print(ve)
            continue
        plugins.PolyLineTextPath(
            line,
            '\u276F              ',
            repeat=True,
            offset=7,
            fill_opacity=3,
            attributes=attr
        ).add_to(group)

def Write_Route(WayPointGPS_list,RouteName):
    group_str = str("Route: "+RouteName)
    group = plugins.FeatureGroupSubGroup(rt,group_str,show=True)
    my_map.add_child(group)
    for each in WayPointGPS_list:
        folium.CircleMarker(
            location = each,
            fill='true',
            radius = 2,
            tooltip= RouteName ,
            fill_color ='red',
            color = 'clear',
            fill_opacity=3
        ).add_to(group)
    line = folium.PolyLine(WayPointGPS_list, color="brown", weight=2.5, opacity=1,icons='arrow').add_to(group)
    attr = {'font-weight': 'regular', 'font-size': '20', 'color' : 'brown'}
    plugins.PolyLineTextPath(
        line,
        '\u276F              ',
        repeat=True,
        offset=7,
        fill_opacity=3,
        attributes=attr
    ).add_to(group)

def Write_Way(Way_Num, GPS, Time):

    group_str = str("Way_"+str(Way_Num))
    group = plugins.FeatureGroupSubGroup(wg, group_str) 
    my_map.add_child(group)
    folium.Marker(location=GPS, icon=folium.Icon(color='blue', icon='anchor', prefix='fa'), tooltip=group_str+" : "+str(Time)).add_to(group)

def Write_Mark(Mark_Num, GPS, Time):
     
    group_str = str("Mark_"+str(Mark_Num))
    group = plugins.FeatureGroupSubGroup(mg, group_str) 
    my_map.add_child(group)     
    folium.Marker(location=GPS, icon=folium.Icon(color='red', icon='bookmark', prefix='fa'), tooltip=group_str+" : "+str(Time), ).add_to(group)

def Write_Message(Message_Num, GPS, Time, content):
    group_str = str("Message_"+str(Message_Num))
    group = plugins.FeatureGroupSubGroup(msgg, group_str) 
    my_map.add_child(group)

    folium.Marker(location=GPS, icon=folium.Icon(color='orange', icon='envelope', prefix='fa'), tooltip=group_str+" : "+str(Time) + "\n" + "Content : "+ str(content) ).add_to(group)

def Message_carve(msg_type,filepath):
    if msg_type == 'rcv':
        rp = filepath + '\\rcvmsg.txt'
        msg = open(rp, 'rb')
        msg_str = "Receive Message"

    if msg_type == 'send':
        rp = filepath + '\\sendmsg.txt'
        msg = open(rp, 'rb')
        msg_str = "Send Message"
        
    msg_struct = msg.read(0xD4)
    msg_num = 1
    msg_lat = 0
    msg_lon = 0
    gps = [msg_lat,msg_lon]
    print(msg_type)
    while msg_struct:
        msg_time = msg_struct[0x00:0x07]
        time = struct.unpack('< hbbbbb', msg_time)
        
        if msg_time[0] != 0:
            try:
                time = datetime.datetime(*time, tzinfo=datetime.timezone.utc)
            except:
                time = 'unknown'
            chinatime = time if type(time) == str else time.astimezone(datetime.timezone(datetime.timedelta(hours=8)))
            ksttime = time if type(time) == str else time.astimezone(datetime.timezone(datetime.timedelta(hours=9)))
            msg_struct.replace(b'\x00', b'')
            if msg_struct[0x20:0x24].decode('ascii') == 'POS:':
                msg_content = msg_struct[0x10:0x20].decode('ascii')
                msg_lat = (msg_struct[0x24:0x26]+b"."+msg_struct[0x27:0x29]+msg_struct[0x2A:0x2D]).decode('ascii')
                msg_lon = (msg_struct[0x2F:0x32]+b"."+msg_struct[0x33:0x34]+msg_struct[0x35:0x38]).decode('ascii')
            else :
                msg_content = msg_struct[0x10:0xB3].decode('ascii')
            msg_mmsi = struct.unpack('<i', msg_struct[0xB4:0xB8])[0]
            if msg_mmsi == 0 :
                msg_mmsi = 'broadCast'
            
            gps = [msg_lat, msg_lon]
            
            print(msg_str,"-",msg_num)
            print("Time    : ",ksttime)
            print("Content : ",msg_content)
            if msg_type == 'rcv':
                if msg_struct[0x20:0x24].decode('ascii') == 'POS:' :
                    print("POS     : ", gps)
                Write_Message(msg_num, gps, time, msg_content)
            print("mmsi    : ",msg_mmsi)
            msg_struct = msg.read(0xD4)
            msg_num +=1
        else:
            break


def Track_Carve(option,filepath,MarkP,WayP,RouteP,functionNumber):
    important = []
    Timelist = [] 
    MarkAWay_list = [] 
    WayPoint_list = []
    n = 0
    Lat = ''
    path = filepath  + '\\track.dat'
    file = open(path,"rb")
    file_size = (len(file.read()))
    file.seek(0)
    bin = file.read(file_size)
    Track_N = (struct.unpack('<HH',bin[0:4])[0])
    print("전체 항적 데이터 개수 : " , Track_N)
    Num = 0
    point_data = Point_Carve('way',WayP)[1] + Point_Carve('mark',MarkP)[1]
    MarkAWay_list.extend(Point_Carve('mark',MarkP)[1] + Point_Carve('way',WayP)[1])
    Timelist.extend(Point_Carve('mark',MarkP)[2] + Point_Carve('way',WayP)[2])
    WayPoint_list.extend(Point_Carve('way',WayP)[1])
    Route_Carve(WayPoint_list,RouteP)
    while Num < Track_N:
        GPS_list = []
        Num += 1
        file.seek(4+n)
        binary = file.read(file_size)

        Track_number = str(struct.unpack('<H',binary[0:2])[0])
        String = binary[2:11].decode('euc-cn')
        reserved_area = binary[11:20].hex().upper()

        Latdegree = struct.unpack('<H', binary[20:22])[0]
        Latminute = struct.unpack('<H', binary[22:24])[0]
        Latdecimal = struct.unpack('<H', binary[24:26])[0]
        Londegree = struct.unpack('<H', binary[26:28])[0]
        Lonminute = struct.unpack('<H', binary[28:30])[0]
        Londecimal = struct.unpack('<H', binary[30:32])[0]
        
        what1 = binary[32:36].hex().upper()
        what2 = binary[36:40].hex().upper()
        distance = binary[40:41].hex().upper()
        color = binary[41:42].hex().upper()
        what3 = binary[42:43].hex().upper()
        what4 = binary[43:44].hex().upper()
        Track_len = struct.unpack('<HH', binary[44:48])[0]
        Track_offset = struct.unpack('<i', binary[48:52])[0]
        
        Track_data_size = (Track_len-1)*8+48

        Track_data = bin[Track_offset:Track_offset+Track_data_size]

        lat_num = lati_accumulate(Latdegree, Latminute, Latdecimal)
        lon_num = longi_accumulate(Londegree, Lonminute, Londecimal)
        track_n = 1
        t = 0

        GPS_list.append([
            Latdegree + ((Latminute + (Latdecimal/1000)) / 60),
            Londegree + ((Lonminute + (Londecimal/1000)) / 60)
        ])
        
        option1 = option
        point_check = 0
        while t < Track_data_size-48:
            
            move = Track_data[t:t+8]
            movelon = struct.unpack('<i', move[0:4])[0]
            movelat = struct.unpack('<i', move[4:8])[0]
            latitude = reverse_gps(lat_num + movelat)
            longitude = reverse_gps(lon_num + movelon)
            GPS_list.append([float(latitude),float(longitude)])
            for i in point_data:
                if float(latitude)+float(0.001) > i[0] > float(latitude)-float(0.001) and float(longitude)+float(0.001) > i[1] > float(longitude)-float(0.001):
                    point_check += 1
            if point_check > 0:
                option1 = True
                important.append("Track_"+str(Num))
            track_n += 1
            t += 8
            Write_Track(String, str(Num), GPS_list, option1)
        if(functionNumber == 2):
            AnalsisArgument(String,GPS_list,MarkAWay_list,Timelist)
        n += 52
    return Num, set(important)

def Point_Carve(datatype,filepath):
    if datatype == 'way':

        data = open(filepath+'\\waypoint.dat', 'rb')
    if datatype == 'mark':
        data = open(filepath+'\\markpoint.dat', 'rb')

    wp_struct = data.read(0x2E)
    gps_list = []
    time_value = []

    while wp_struct:
        
        name = wp_struct[0:8].decode('euc-cn').replace('\0', '')
        latitude = struct.unpack('< hhh', wp_struct[0x14:0x1A])
        latiaccu = lati_accumulate(*latitude)
        latitude = latitude[0] + ((latitude[1] + (latitude[2] / 1000)) / 60)
        
        longitude = struct.unpack('< hhh', wp_struct[0x1A:0x20])
        longiaccu = longi_accumulate(*longitude)
        longitude = longitude[0] + ((longitude[1] + (longitude[2] / 1000)) / 60)
        
        GPS = [float(latitude), float(longitude)]
        
        time = struct.unpack('< hbbbbb', wp_struct[0x20: 0x27])
        try:
            time = datetime.datetime(*time, tzinfo=datetime.timezone.utc)
        except:
            time = 'unknown'
        
        gps_list.append([float(latitude), float(longitude)])
        number = struct.unpack('< h', wp_struct[0x2A: 0x2C])[0]
        symbol = wp_struct[0x2C]
        color = ['brown', 'red', 'dark green', 'light green', 'navy', 'blue', 'purple', 'blue-green'][wp_struct[0x2D]]
        accu = '{0:#010x} {1:#010x}'.format(latiaccu, longiaccu)
        chinatime = time if type(time) == str else time.astimezone(datetime.timezone(datetime.timedelta(hours=8)))
        ksttime = time if type(time) == str else time.astimezone(datetime.timezone(datetime.timedelta(hours=9)))
        time_value.append(ksttime)
        if datatype == 'mark':
            Write_Mark(number, GPS, ksttime)
        if datatype == 'way':
            Write_Way(number, GPS, ksttime)
            
        wp_struct = data.read(0x2E)
   
    return number, gps_list,time_value
    
if __name__ == "__main__":
    
    if(len(sys.argv) < 3 ):
        print("Usage <FolderPath> <Function number>")
        print("Usage <RcvMessage> <Function number> <SendMessage>")
        print("Usage <TrackP> <Function number> <MarkPointP> <WayPointP> <RouteP>")
        sys.exit(0)
      
    trackPath = ""
    filepath = ""    
    functionNumber = 0
    markPointP = ""
    WayPointP = ""
    RecvMP = ""
    SendMP = ""
    RouteP = ""

    if(len(sys.argv) == 3):
        trackPath = sys.argv[1]
        markPointP = sys.argv[1]
        WayPointP = sys.argv[1]
        RecvMP = sys.argv[1]
        SendMP = sys.argv[1]
        RouteP = sys.argv[1]
        functionNumber = int(sys.argv[2])
    elif(len(sys.argv) == 6):
        trackPath = sys.argv[1]
        functionNumber = int(sys.argv[2])
        markPointP = sys.argv[3]
        WayPointP = sys.argv[4]
        RouteP = sys.argv[5]
    elif(len(sys.argv) == 4):
        functionNumber = int(sys.argv[2])
        RecvMP = sys.argv[1]
        SendMP = sys.argv[3]
        
    if functionNumber == 1 or 2:
        Track_Carve = Track_Carve(option_1,trackPath,markPointP,WayPointP,RouteP,functionNumber)
        folium.LayerControl(collapsed=False).add_to(my_map)
        my_map.save("./AIS9000.html")

    if functionNumber == 3:
        Message_carve('rcv',RecvMP)
        print("ep")
        Message_carve('send',SendMP)
        print("ed")