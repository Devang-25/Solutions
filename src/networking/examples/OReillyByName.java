package networking.examples;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class OReillyByName {
	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getByName("www.oreilly.com");
			System.out.println(address);
		} catch (UnknownHostException ex) {
			System.out.println("Could not find www.oreilly.com");
		}

		// /////////////////////
		System.out.println();
		try {
			InetAddress[] addresses = InetAddress
					.getAllByName("www.oreilly.com");
			for (InetAddress address : addresses) {
				System.out.println(address);
			}
		} catch (UnknownHostException ex) {
			System.out.println("Could not find www.oreilly.com");
		}

		// ////////////////////////
		byte[] address = { 107, 23, (byte) 216, (byte) 196 };
		try {
			InetAddress lessWrong = InetAddress.getByAddress(address);
			System.out.println(lessWrong);
			InetAddress lessWrongWithname = InetAddress.getByAddress(
					"lesswrong.com", address);
			System.out.println(lessWrongWithname);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static int getVersion(InetAddress ia) {
		byte[] address = ia.getAddress();
		if (address.length == 4)
			return 4;
		else if (address.length == 16)
			return 6;
		else
			return -1;
	}

	public static void test(String[] args) {
		try {
			InetAddress address = InetAddress.getByName(args[0]);
			if (address.isAnyLocalAddress()) {
				System.out.println(address + " is a wildcard address.");
			}
			if (address.isLoopbackAddress()) {
				System.out.println(address + " is loopback address.");
			}
			if (address.isLinkLocalAddress()) {
				System.out.println(address + " is a link-local address.");
			} else if (address.isSiteLocalAddress()) {
				System.out.println(address + " is a site-local address.");
			} else {
				System.out.println(address + " is a global address.");
			}
			if (address.isMulticastAddress()) {
				if (address.isMCGlobal()) {
					System.out.println(address
							+ " is a global multicast address.");
				} else if (address.isMCOrgLocal()) {
					System.out.println(address
							+ " is an organization wide multicast address.");
				} else if (address.isMCSiteLocal()) {
					System.out.println(address
							+ " is a site wide multicast address.");
				} else if (address.isMCLinkLocal()) {
					System.out.println(address
							+ " is a subnet wide multicast address.");
				} else if (address.isMCNodeLocal()) {
					System.out.println(address
							+ " is an interface-local multicast address.");
				} else {
					System.out.println(address
							+ " is an unknown multicast address type.");
				}
			} else {
				System.out.println(address + " is a unicast address.");
			}
		} catch (UnknownHostException ex) {
			System.err.println("Could not resolve " + args[0]);
		}
	}
	
	public static void testEqualsInetAddress (String args[]) {
		try {
		InetAddress ibiblio = InetAddress.getByName("www.ibiblio.org");
		InetAddress helios = InetAddress.getByName("helios.ibiblio.org");
		if (ibiblio.equals(helios)) {
		System.out.println
		("www.ibiblio.org is the same as helios.ibiblio.org");
		} else {
		System.out.println
		("www.ibiblio.org is not the same as helios.ibiblio.org");
		}
		} catch (UnknownHostException ex) {
		System.out.println("Host lookup failed.");
		}
		}
}
